package kr.co.basic.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Dao {
    private Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    public void insert() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into member(username,password) values('user01','1234')");
    }

    public void print() {
        try {

            Statement statement = connection.createStatement();
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
