package org.education.hospitalmanagmentapp.services;

import org.education.hospitalmanagmentapp.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * AuthService manages user authentication and registration processes.
 */
public class AuthService {

    private static final String DB_URL = "jdbc:sqlserver://your_server.database.windows.net:1433;databaseName=your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    /**
     * Authenticates a user based on username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return User object if authentication is successful, null otherwise
     */
    public boolean login(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"), rs.getString("email")); // Adjust according to your User model
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Registers a new user in the database.
     *
     * @param user the user object to be registered
     * @return true if registration is successful, false otherwise
     */
    public boolean register(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
