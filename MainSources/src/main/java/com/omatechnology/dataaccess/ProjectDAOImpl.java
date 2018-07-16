package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.sql.PreparedStatement;

public class ProjectDAOImpl implements ProjectDAOInterface {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void insert(Project project) {
        try {
            databaseConnection.connect();
            String sql = "INSERT INTO projects(Name,Manager,Client,ReleaseDate,Description,Status) " +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getManager());
            preparedStatement.setString(3, project.getClient());
            preparedStatement.setString(4, project.getReleaseDate());
            preparedStatement.setString(5, project.getDescription());
            preparedStatement.setString(6, project.getStatus());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }
}
