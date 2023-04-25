module com.example.klient1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.klient1 to javafx.fxml;
    exports com.example.klient1;
    exports answer;
    opens answer to javafx.fxml;
}