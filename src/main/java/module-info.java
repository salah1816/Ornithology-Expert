module com.example.psychiatreexpert {
    requires javafx.controls;
    requires javafx.fxml;


    opens modal to javafx.fxml;
    exports modal;
}