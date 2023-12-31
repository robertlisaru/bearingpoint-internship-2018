package com.omatechnology.dataaccess;

import com.omatechnology.entities.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Project getProjectByID(String id) {
        Project project = null;
        try {
            databaseConnection.connect();
            String sql = "SELECT Name, Manager,  Client, ReleaseDate, Description, Status FROM projects WHERE ID=?;";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                String manager = rs.getString("Manager");
                String client = rs.getString("Client");
                String releaseDate = rs.getString("ReleaseDate");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                project = new Project(name, manager, client, releaseDate, description, status);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        try {
            databaseConnection.connect();
            String sql = "UPDATE projects " +
                    "SET Name=?, Manager=?, Client=?, ReleaseDate=?, Description=?, Status=? " +
                    "WHERE ID=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getManager());
            preparedStatement.setString(3, project.getClient());
            preparedStatement.setString(4, project.getReleaseDate());
            preparedStatement.setString(5, project.getDescription());
            preparedStatement.setString(6, project.getStatus());
            preparedStatement.setString(7, project.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public void deleteProjectByID(String id) {
        try {
            databaseConnection.connect();
            String sql = "DELETE FROM tasks WHERE ProjectID=?";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            sql = "DELETE FROM projects WHERE ID=?";
            preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public List<Project> getProjectsByUsername(String username) {
        List<Project> projectList = new ArrayList<>();
        try {
            databaseConnection.connect();
            String sql = "select p.ID, p.Name, p.Manager, p.Client, p.ReleaseDate, p.Description, p.Status " +
                    "from projects p inner join projectmembers pm on p.ID=pm.ProjectID " +
                    "where pm.Username=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String manager = rs.getString("Manager");
                String client = rs.getString("Client");
                String releaseDate = rs.getString("ReleaseDate");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Project project = new Project(name, manager, client, releaseDate, description, status);
                projectList.add(project);
                project.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "select p.ID, p.Name, p.Manager, p.Client, p.ReleaseDate, p.Description, p.Status " +
                    "from projects p " +
                    "where p.Manager=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String manager = rs.getString("Manager");
                String client = rs.getString("Client");
                String releaseDate = rs.getString("ReleaseDate");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Project project = new Project(name, manager, client, releaseDate, description, status);
                project.setId(id);
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        databaseConnection.close();
        return projectList;
    }
}
