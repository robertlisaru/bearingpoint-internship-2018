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
            String sql = "INSERT INTO tasks(TaskName,ProjectID,EstimatedTime,Status ) " +
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
    public List<Task> getTasksByProjectId(String id) {
        List<Task> taskList = new ArrayList<>();
        try {
            databaseConnection.connect();
            String sql = "SELECT t.TaskName,t.DueDate, t.Status " +
                    " FROM tasks t WHERE ProjectID=?";

            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("TaskName");
                String estimatedDate = rs.getString("DueDate");
                String status = rs.getString("Status");
                Task task = new Task(name, estimatedDate, status);
                taskList.add(task);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        databaseConnection.close();
        return taskList;
    }
}
