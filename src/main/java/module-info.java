module code.javarpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens code.javarpg to javafx.fxml;
    exports code.javarpg;
}