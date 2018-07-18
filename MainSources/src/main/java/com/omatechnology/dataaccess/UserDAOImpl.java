package com.omatechnology.dataaccess;

import com.omatechnology.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAOInterface {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void insert(User user) {
        try {
            databaseConnection.connect();

            String sql = "INSERT INTO users (Username,Password,Email,Gender) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getGender());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            databaseConnection.connect();
            String sql = "SELECT * FROM users where Username=?";
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String gender = rs.getString("Gender");
                user.setPassword(password);
                user.setEmail(email);
                user.setGender(gender);
                user.setUsername(username);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

