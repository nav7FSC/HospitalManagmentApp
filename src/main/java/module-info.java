module org.education.hospitalmanagmentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.education.hospitalmanagmentapp to javafx.fxml;
    exports org.education.hospitalmanagmentapp;
}