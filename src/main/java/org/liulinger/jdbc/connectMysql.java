package org.liulinger.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectMysql {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://129.211.26.208/javaweb";
        String username = "root";
        String password = "1GVHFVoEp0R98woH8RCG";
        return DriverManager.getConnection(url, username, password);
    }

    public connectMysql() {
    }
}
