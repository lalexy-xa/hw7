package org.example.dao;

import org.example.DatabaseStorage;
import org.example.dto.ProjectDto;
import org.example.dto.WorkerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectDao {
    private static final String INSERT_PROJECT_PREPARED_STATMENT =
            "INSERT INTO project ( \"CLIENT_ID\", \"START_DATE\", \"FINISH_DATE\") VALUES (?,?,?)";

    public void insertProject(List<ProjectDto> projects) throws SQLException {
        Connection connection = DatabaseStorage.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_PREPARED_STATMENT);
        for (ProjectDto project : projects) {
            preparedStatement.setInt(1, project.getClientId());
            preparedStatement.setObject(2, project.getStartDate());
            preparedStatement.setObject(3, project.getFinishDate());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
