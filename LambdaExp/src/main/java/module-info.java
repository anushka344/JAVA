module com.example.lambdaexp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lambdaexp to javafx.fxml;
    exports com.example.lambdaexp;
}