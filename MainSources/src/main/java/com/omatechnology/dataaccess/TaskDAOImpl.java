package com.omatechnology.dataaccess;

import com.omatechnology.entities.Task;
import java.sql.PreparedStatement;


public class TaskDAOImpl implements TaskDAOInterface {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void insert(Task task) {
        try{
        databaseConnection.connect();
        String sql="INSERT INTO tasks(TaskName,ProjectID,EstimatedTime,Status ) " +
                "VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1, task.getName());
        preparedStatement.setInt(2, task.getProjectID());
        preparedStatement.setString(3, task.getEstimatedDate());
        preparedStatement.setString(4, task.getStatus());


        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        databaseConnection.close();
    }
    }
}
