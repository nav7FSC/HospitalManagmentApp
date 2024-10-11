package org.education.hospitalmanagmentapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.education.hospitalmanagmentapp.models.Patient;
import org.education.hospitalmanagmentapp.services.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * PatientController handles patient-related actions such as adding, updating, and retrieving patient data.
 */
public class PatientController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField dateOfBirthField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField medicalHistoryField;

    private DatabaseConnector dbConnector = new DatabaseConnector();

    /**
     * Adds a new patient to the database.
     */
    @FXML
    public void handleAddPatient() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        String gender = genderField.getText();
        String contactNumber = contactNumberField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String medicalHistory = medicalHistoryField.getText();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            showAlert("Error", "First name and last name are required.");
            return;
        }

        try (Connection conn = dbConnector.getConnection()) {
            String sql = "INSERT INTO Patients (firstName, lastName, dateOfBirth, gender, contactNumber, email, address, medicalHistory) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, dateOfBirth);
            pstmt.setString(4, gender);
            pstmt.setString(5, contactNumber);
            pstmt.setString(6, email);
            pstmt.setString(7, address);
            pstmt.setString(8, medicalHistory);
            pstmt.executeUpdate();
            showAlert("Success", "Patient added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add patient.");
        }
    }

    /**
     * Retrieves patient data based on the provided patient ID.
     *
     * @param patientId the patient ID to look up
     * @return the Patient object or null if not found
     */
    public Patient fetchPatientById(int patientId) {
        try (Connection conn = dbConnector.getConnection()) {
            String sql = "SELECT * FROM Patients WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Patient(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("gender"),
                        rs.getString("contactNumber"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("medicalHistory")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Shows an alert dialog with the specified title and content.
     *
     * @param title   the title of the alert
     * @param content the content of the alert
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
