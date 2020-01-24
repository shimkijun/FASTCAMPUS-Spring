package kr.co.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException {
        logger.info("Hello World");
        Class.forName("org.h2.Driver");
        var url = "jdbc:h2:~/test;MODE=MySQL";
        try (var connection = DriverManager.getConnection(url,"sa","");
             var statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.executeUpdate("drop table member");
            statement.execute("create table member(id int auto_increment,username varchar(255) not null , password varchar(255) not null,primary key(id))");
            try {
                statement.executeUpdate("insert into member(username,password) values('user01','1234')");
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }

            var resultSet = statement.executeQuery("select * from member");
            while (resultSet.next()){
                var member = new Member(resultSet);
                logger.info(member.toString());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
