package kr.co.basic.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String driverClass;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String driverClass,String url, String user, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = this.url;
        return DriverManager.getConnection(url,this.user,this.password);
    }
}
