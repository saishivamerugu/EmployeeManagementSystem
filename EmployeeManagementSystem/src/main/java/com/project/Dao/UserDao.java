package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.model.User;
import com.project.utils.Constants;
import com.project.utils.DBConnection;

public class UserDao {
    
    public void saveUser(User user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.INSERT_USER)) {
            
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validateUser(User user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.GET_USER)) {
            
            statement.setString(1, user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                return user.getPassword().equals(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
