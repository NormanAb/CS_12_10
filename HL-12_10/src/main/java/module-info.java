module com.example.hl12_10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hl12_10 to javafx.fxml;
    exports com.example.hl12_10;
}