package org.education.hospitalmanagmentapp.models;

import java.util.regex.Pattern;

/**
 * User represents a user in the hospital management system.
 */
public class User {

    private String username;
    private String password; // Consider storing a hashed password
    private String role;

    /**
     * Constructs a User object with the specified username, password, and role.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param role     the role of the user (e.g., Admin, Doctor, Nurse)
     */
    public User(String username, String password, String role) {
        setUsername(username);
        setPassword(password); // Hash the password before setting
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username;
    }

    public String getPassword() {
        return password; // Return hashed password if applicable
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6) { // Example validation
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }
        // Hash the password before storing
        this.password = hashPassword(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Example password hashing method (replace with actual implementation)
    private String hashPassword(String password) {
        // Implement password hashing logic here (e.g., using BCrypt)
        return password; // Replace with hashed password
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}'; // Don't include password for security
    }
}
