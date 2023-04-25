module com.example.server {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.server to javafx.fxml;
    exports com.example.server;
    exports answer;
    opens answer to javafx.fxml;
}