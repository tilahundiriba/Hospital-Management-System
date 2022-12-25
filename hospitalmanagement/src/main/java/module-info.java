module com.example.hospitalmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hospitalmanagement to javafx.fxml;
    exports com.example.hospitalmanagement;
}