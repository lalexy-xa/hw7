package org.example;

import java.sql.*;
import java.util.Objects;

public class DatabaseStorage {
    private static final String DB_URL="jdbc:h2:~/test";
    private static final  String USERNAME ="sa";
    private static final String PASSWORD="";

    private static Connection connection;

    private DatabaseStorage(){

    }

    public static Connection getConnection() throws SQLException{
        if(Objects.isNull(connection)){
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }

        if(!connection.isValid(1000)){
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }

        return connection;
    }
}
