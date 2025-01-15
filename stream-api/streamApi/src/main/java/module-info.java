module com.example.streamapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.streamapi to javafx.fxml;
    exports com.example.streamapi;
}