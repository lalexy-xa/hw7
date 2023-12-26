package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseInitService {
    private static final String INIT_DB_PATH = "src/main/resources/sql/init_db.sql";

    public static void main(String[] args) throws IOException, SQLException {
        Connection connection =  DatabaseStorage.getConnection();
        String initDBQuery = new String(Files.readAllBytes(Paths.get(INIT_DB_PATH)));
        Statement stmt = connection.createStatement();
        stmt.execute(initDBQuery);
        connection.close();

    }
}
