package com.myproject.connectionmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@EJB
public class ConnectionManagerJdbcImpl implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerJdbcImpl.class);

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/my_online_shop?serverTimezone=UTC&useSSL=false",
                    "root",
                    "roma");
        } catch (SQLException e) {
            LOGGER.error("Something wrong in getConnection method", e);
        }
        return connection;
    }
}