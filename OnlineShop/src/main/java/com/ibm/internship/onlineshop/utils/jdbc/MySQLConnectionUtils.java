package com.ibm.internship.onlineshop.utils.jdbc;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class MySQLConnectionUtils {

    private Logger logger = Logger.getLogger(MySQLConnectionUtils.class);

    private static final String HOSTNAME = "127.0.0.1";
    private static final String DATABASE_NAME = "onlineshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Establish connection with MySQL database
     *
     * @return a Connection object
     * @throws IllegalAccessException if the connection to database fails
     * @throws ClassNotFoundException
     */
    public Connection getMySQLConnection() throws IllegalAccessException, ClassNotFoundException {
        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DATABASE_NAME;
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
            logger.debug("Connected successfully.");
            return connection;
        } catch (SQLException e) {
            logger.debug("Failed connection.");
            throw new IllegalAccessException(e.getMessage());
        }
    }
}
