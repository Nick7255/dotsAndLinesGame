module com.example.dotsandlinesgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dotsandlinesgame to javafx.fxml;
    exports com.example.dotsandlinesgame;
}