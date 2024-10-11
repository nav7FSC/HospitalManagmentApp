package org.education.hospitalmanagmentapp.services;

import org.education.hospitalmanagmentapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DatabaseService handles all operations related to the database.
 */
public class DatabaseService {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    /**
     * Saves a user to the database.
     *
     * @param user The user object to be saved.
     * @return true if the user is successfully saved, false otherwise.
     */
    public boolean saveUser(User user) {
        String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
        try (Connection connection = databaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks if the user's credentials are valid.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if the credentials are valid, false otherwise.
     */
    public boolean checkUserCredentials(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection connection = databaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();  // Returns true if a record is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
