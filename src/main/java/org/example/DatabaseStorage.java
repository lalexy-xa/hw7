package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseStorage {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_PASSWORD = "";
    private static final String DB_USER_NAME="sa";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
    }
}
