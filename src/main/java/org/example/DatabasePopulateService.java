package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabasePopulateService {
    private static final String INIT_DB_POPULATE_PATH = "src/main/resources/sql/populate_db.sql";

    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DatabaseStorage.getConnection();
        String insertDBQuery = new String(Files.readAllBytes(Paths.get(INIT_DB_POPULATE_PATH)));
        PreparedStatement stmt = connection.prepareStatement(insertDBQuery);
        stmt.executeUpdate();
        connection.close();

    }
}
