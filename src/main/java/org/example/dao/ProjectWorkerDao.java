package org.example.dao;

import org.example.DatabaseStorage;
import org.example.dto.ProjectWorkerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectWorkerDao {
    private static final String INSERT_PROJECT_WORKER_PREPARED_STATMENT =
            "INSERT INTO project_worker ( \"PROJECT_ID\", \"WORKER_ID\") VALUES (?,?)";

    public void insertProjectWorker(List<ProjectWorkerDto> projects) throws SQLException {
        Connection connection = DatabaseStorage.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_WORKER_PREPARED_STATMENT);
        for (ProjectWorkerDto project : projects) {
            preparedStatement.setInt(1, project.getProjectId());
            preparedStatement.setInt(2, project.getWorkerId());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
