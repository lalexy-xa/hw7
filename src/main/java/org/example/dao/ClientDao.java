package org.example.dao;

import org.example.DatabaseStorage;
import org.example.dto.ClientDto;
import org.example.dto.WorkerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientDao {
    private static final String INSERT_CLIENT_PREPARED_STATMENT =
            "INSERT INTO client ( \"NAME\") VALUES (?)";

    public void insertClient(List<ClientDto> clients) throws SQLException {
        Connection connection = DatabaseStorage.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_PREPARED_STATMENT);
        for (ClientDto client : clients) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
