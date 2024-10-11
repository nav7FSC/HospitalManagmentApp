package org.education.hospitalmanagmentapp.services;

import org.education.hospitalmanagmentapp.models.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointmentList = new ArrayList<>();

    /**
     * Adds a new appointment to the list.
     *
     * @param appointment The appointment to add.
     */
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    /**
     * Retrieves all the appointments.
     *
     * @return A list of all appointments.
     */
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointmentList);
    }

    /**
     * Removes an appointment from the list.
     *
     * @param appointmentId The ID of the appointment to remove.
     */
    public void removeAppointment(int appointmentId) {
        appointmentList.removeIf(appointment -> appointment.getId() == appointmentId);
    }

    // You can implement more methods like updateAppointment, findAppointmentById, etc.
}
