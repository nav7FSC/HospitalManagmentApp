package org.education.hospitalmanagmentapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import org.education.hospitalmanagmentapp.models.Appointment;
import org.education.hospitalmanagmentapp.services.AppointmentService;

import java.time.LocalDate;

public class AppointmentController {

    @FXML
    private TextField patientIdField;
    @FXML
    private TextField doctorIdField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> timeComboBox;  // Dropdown for appointment times
    @FXML
    private TableView<Appointment> appointmentTable;  // Table to display appointments

    private AppointmentService appointmentService = new AppointmentService();

    /**
     * Initializes the appointment form with default values.
     */
    @FXML
    public void initialize() {
        timeComboBox.getItems().addAll("09:00", "10:00", "11:00", "14:00", "15:00", "16:00");
        loadAppointments();
    }

    /**
     * Handles the scheduling of a new appointment.
     */
    @FXML
    public void handleScheduleAppointment() {
        String patientId = patientIdField.getText();
        String doctorId = doctorIdField.getText();
        LocalDate date = datePicker.getValue();
        String time = timeComboBox.getValue();

        if (patientId.isEmpty() || doctorId.isEmpty() || date == null || time == null) {
            showAlert("Missing Information", "Please fill in all fields to schedule an appointment.");
            return;
        }

        // Create a new appointment
        Appointment newAppointment = new Appointment(0, patientId, doctorId, date.toString(), time, "Scheduled");
        appointmentService.addAppointment(newAppointment);

        // Reload appointments to show the newly added one
        loadAppointments();
    }

    /**
     * Loads appointments into the table view.
     */
    private void loadAppointments() {
        appointmentTable.getItems().setAll(appointmentService.getAllAppointments());
    }

    /**
     * Displays an alert dialog with the specified title and content.
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
