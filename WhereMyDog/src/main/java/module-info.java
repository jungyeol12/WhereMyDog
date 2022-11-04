module com.example.wheremydog {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml;


    opens com.example.wheremydog to javafx.fxml;
    exports com.example.wheremydog;
}