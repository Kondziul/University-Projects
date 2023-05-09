module com.example.kolkokrzyzyk2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kolkokrzyzyk2 to javafx.fxml;
    exports com.example.kolkokrzyzyk2;
}