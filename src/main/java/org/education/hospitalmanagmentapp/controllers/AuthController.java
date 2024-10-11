package org.education.hospitalmanagmentapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.education.hospitalmanagmentapp.services.AuthService;

/**
 * AuthController handles user login, registration, and displays error messages if authentication fails.
 */
public class AuthController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    private final AuthService authService = new AuthService();

    /**
     * Attempts to log in the user with the provided username and password.
     * If successful, it redirects the user to the main dashboard.
     * If unsuccessful, it shows an error message.
     */
    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if fields are empty
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password.");
            return;
        }

        // Attempt to log in using the AuthService
        boolean isAuthenticated = authService.login(username, password);

        // Check authentication result
        if (isAuthenticated) {
            loadDashboard();
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    /**
     * Handles user registration by navigating to the registration view.
     */
    @FXML
    public void handleRegister() {
        SceneManager.loadScene("RegistrationView.fxml");
    }

    /**
     * Loads the main dashboard after a successful login.
     */
    private void loadDashboard() {
        System.out.println("Successfully logged in!");
        SceneManager.loadScene("DashboardView.fxml");
    }

    /**
     * Exits the application, closing the stage.
     */
    @FXML
    public void handleExit() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();
    }
}
