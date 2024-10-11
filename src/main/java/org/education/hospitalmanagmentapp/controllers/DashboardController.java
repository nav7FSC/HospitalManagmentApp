package org.education.hospitalmanagmentapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * DashboardController manages the main dashboard view for the Hospital Management App.
 * It handles actions like navigating to different parts of the system and displaying data.
 */
public class DashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button viewPatientsButton;

    @FXML
    private Button addPatientButton;

    @FXML
    private TableView<?> patientTableView; // Placeholder for a table view to display patient data

    /**
     * Initializes the dashboard and sets up any necessary data.
     * You could also load initial data here, such as recent patients or alerts.
     */
    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome to the Hospital Management Dashboard");
        // Additional setup code can be added here
    }

    /**
     * Handles the action for the "View Patients" button.
     * You could use this method to load the patient list view.
     */
    @FXML
    public void handleViewPatients() {
        // Load the patients view or populate patientTableView with data
        System.out.println("Navigating to the Patients view...");
        SceneManager.loadScene("PatientsView.fxml");
    }

    /**
     * Handles the action for the "Add Patient" button.
     * You could use this method to load the patient registration form.
     */
    @FXML
    public void handleAddPatient() {
        System.out.println("Navigating to Add Patient form...");
        SceneManager.loadScene("AddPatientView.fxml");
    }
}
