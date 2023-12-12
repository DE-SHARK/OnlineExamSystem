package me.xizhehong.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_jb {
    public Connection getConnections() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");        //  建立连接对象
        String url = "jdbc:mysql://localhost:3307/javaweb";
        String username = "root";
        String password = "123456";
        Connection connections = DriverManager.getConnection(url, username, password);
        return connections;
    }

    public Connection_jb() throws SQLException {
    }
}

