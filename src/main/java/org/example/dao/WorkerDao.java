package org.example.dao;

import org.example.DatabaseStorage;
import org.example.dto.WorkerDto;

import java.sql.*;
import java.util.List;

public class WorkerDao {
    private static final String INSERT_WORKER_PREPARED_STATMENT =
            "INSERT INTO worker ( \"NAME\", \"BIRTHDAY\", \"LEVEL\", \"SALARY\") VALUES (?,?,?,?)";

    public void insertWorker(List<WorkerDto> workers) throws SQLException {
        Connection connection = DatabaseStorage.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_PREPARED_STATMENT);
        for (WorkerDto worker: workers){
//            preparedStatement.setInt(1, worker.getId());
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setObject(2,  worker.getBirthday());
            preparedStatement.setString(3, worker.getLevel());
            preparedStatement.setInt(4, worker.getSalary());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
