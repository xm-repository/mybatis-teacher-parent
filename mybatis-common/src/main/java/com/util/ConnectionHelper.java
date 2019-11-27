package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cj
 * @date 2019/10/12
 */
public class ConnectionHelper {

    public static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
