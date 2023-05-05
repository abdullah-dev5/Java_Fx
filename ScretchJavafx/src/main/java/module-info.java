module com.example.scretchjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scretchjavafx to javafx.fxml;
    exports com.example.scretchjavafx;
}