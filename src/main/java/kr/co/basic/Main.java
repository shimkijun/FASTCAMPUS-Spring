package kr.co.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("Hello World");

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:~/test;MODE=MySQL";
            connection = DriverManager.getConnection(url,"sa","");
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from member");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                logger.info("id : " + id + "username : " + username + "password : "+ password);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                statement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            connection.close();
        }
    }
}
