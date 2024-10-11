package org.education.hospitalmanagmentapp;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main application class for the Hospital Management System.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.setStage(primaryStage);  // Set the main stage for SceneManager
        SceneManager.loadScene("LoginView.fxml");  // Load the login scene
        primaryStage.setTitle("Hospital Management System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
