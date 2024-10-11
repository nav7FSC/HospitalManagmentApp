package org.education.hospitalmanagmentapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * SceneManager handles the navigation between different scenes (views) within the application.
 */
public class SceneManager {

    private static Stage stage;

    /**
     * Sets the primary stage for the application.
     *
     * @param primaryStage The main stage of the application.
     */
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    /**
     * Loads a new scene (FXML view) by its file name.
     *
     * @param fxmlFile The name of the FXML file to be loaded (e.g., "LoginView.fxml").
     */
    public static void loadScene(String fxmlFile) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/views/" + fxmlFile));

            // Set the new scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error Loading Scene", "An error occurred while loading the scene: " + e.getMessage());
        }
    }

    /**
     * Displays an error alert dialog to the user.
     *
     * @param title The title of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    private static void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
