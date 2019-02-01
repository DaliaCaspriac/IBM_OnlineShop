package com.ibm.internship.onlineshop.utils.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnectionUtils {

    private static final String HOSTNAME = "localhost";
    private static final String DATABASE_NAME = "onlineshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //connect to MySQL
    public Connection getMySQLConnection() throws IllegalAccessException {
        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DATABASE_NAME;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            //logger
            throw new IllegalAccessException();
        }
    }
}
