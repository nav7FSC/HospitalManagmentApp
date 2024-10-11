package org.education.hospitalmanagmentapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.education.hospitalmanagmentapp.services.AuthService;
import org.education.hospitalmanagmentapp.models.User;

/**
 * RegistrationController handles user registration and displays error messages if registration fails.
 */
public class RegistrationController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private Label errorLabel;

    private final AuthService authService = new AuthService();

    /**
     * Handles user registration when the register button is clicked.
     */
    @FXML
    public void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        User newUser = new User(username, password, email); // Adjust constructor as needed
        boolean registrationSuccessful = authService.register(newUser);

        if (registrationSuccessful) {
            // Navigate to login view or show success message
            SceneManager.loadScene("LoginView.fxml");
        } else {
            errorLabel.setText("Registration failed. Please try again.");
        }
    }

    /**
     * Navigates back to the login view.
     */
    @FXML
    public void handleBack() {
        SceneManager.loadScene("LoginView.fxml");
    }
}
