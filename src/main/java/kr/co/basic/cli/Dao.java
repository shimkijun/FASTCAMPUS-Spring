package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Dao {
    private Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    void init(){
        log.info("init");
    }

    void destroy(){
        log.info("destroy");
    }

    public void run(){
        try {
             Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.executeUpdate("drop table member");
            statement.execute("create table member(id int auto_increment,username varchar(255) not null , password varchar(255) not null,primary key(id))");
            try {
                statement.executeUpdate("insert into member(username,password) values('user01','1234')");
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
            }

            ResultSet resultSet = statement.executeQuery("select * from member");
            while (resultSet.next()){
                Member member = new Member(resultSet);
                log.info(member.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
