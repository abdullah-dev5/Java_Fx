module com.example.tableview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tableview to javafx.fxml;
    exports com.example.tableview;
}