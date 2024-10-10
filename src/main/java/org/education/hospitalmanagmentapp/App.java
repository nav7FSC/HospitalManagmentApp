package org.education.hospitalmanagmentapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    /**
     * Starts the JavaFX application.
     *
     * @param primaryStage the main stage of the application
     * @throws Exception if there's an issue loading the FXML file
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
        primaryStage.setTitle("Hospital Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Main method to launch the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
