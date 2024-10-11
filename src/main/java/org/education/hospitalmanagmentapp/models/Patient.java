package org.education.hospitalmanagmentapp.models;

/**
 * The Patient class represents a patient in the hospital management system.
 * It contains personal details, medical history, and other relevant information about the patient.
 */
public class Patient {
    private int id; // Unique identifier for the patient
    private String firstName; // Patient's first name
    private String lastName; // Patient's last name
    private String dateOfBirth; // Patient's date of birth (format: YYYY-MM-DD)
    private String gender; // Patient's gender (e.g., Male, Female, Other)
    private String contactNumber; // Patient's contact number
    private String email; // Patient's email address
    private String address; // Patient's address
    private String medicalHistory; // Brief description of the patient's medical history

    /**
     * Constructs a new Patient with the specified details.
     *
     * @param id            Unique identifier for the patient.
     * @param firstName     Patient's first name.
     * @param lastName      Patient's last name.
     * @param dateOfBirth   Patient's date of birth.
     * @param gender        Patient's gender.
     * @param contactNumber  Patient's contact number.
     * @param email         Patient's email address.
     * @param address       Patient's address.
     * @param medicalHistory Brief description of the patient's medical history.
     */
    public Patient(int id, String firstName, String lastName, String dateOfBirth, String gender,
                   String contactNumber, String email, String address, String medicalHistory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    /**
     * Returns a string representation of the patient, including their name and ID.
     *
     * @return A string representation of the patient.
     */
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullName='" + firstName + " " + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
