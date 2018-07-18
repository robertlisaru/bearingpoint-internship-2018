package com.omatechnology.dataaccess;

import com.omatechnology.entities.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TaskDAOImpl implements TaskDAOInterface {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void insert(Task task) {
        try {
            databaseConnection.connect();
            String sql = "INSERT INTO tasks(TaskName,ProjectID,DueDate,Status ) " +
                    "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, task.getName());
            preparedStatement.setInt(2, task.getProjectID());
            preparedStatement.setString(3, task.getDueDate());
            preparedStatement.setString(4, task.getStatus());


            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public Task getTaskByID(String id) {
        Task task = null;
        try {
            databaseConnection.connect();
            String sql = "SELECT TaskName, DueDate, Status FROM tasks WHERE ID=?;";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("TaskName");
                String estimatedDate = rs.getString("DueDate");
                String status = rs.getString("Status");
                task = new Task(id, name, estimatedDate, status);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return task;
    }

    @Override
    public void updateTask(Task task) {
        try {
            databaseConnection.connect();
            String sql = "UPDATE tasks " +
                    "SET TaskName=?, DueDate=?, Status=? " +
                    "WHERE ID=? ";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDueDate());
            preparedStatement.setString(3, task.getStatus());
            preparedStatement.setString(4, task.getId());


            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public void deleteTaskByID(String id) {
        try {
            databaseConnection.connect();
            String sql = "DELETE FROM tasks WHERE ProjectID=?";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            sql = "DELETE FROM tasks WHERE ID=?";
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
    public List<Task> getTasksByProjectId(String id) {
        List<Task> taskList = new ArrayList<>();
        try {
            databaseConnection.connect();
            String sql = "SELECT t.ID, t.TaskName,t.DueDate, t.Status " +
                    " FROM tasks t WHERE ProjectID=?";

            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taskId = rs.getString("ID");
                String name = rs.getString("TaskName");
                String estimatedDate = rs.getString("DueDate");
                String status = rs.getString("Status");
                Task task = new Task(taskId, name, estimatedDate, status);
                taskList.add(task);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        databaseConnection.close();
        return taskList;
    }
}
