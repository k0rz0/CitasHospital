module co.edu.uniquindio.citashospital.citashospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.citashospital.citashospital to javafx.fxml;
    exports co.edu.uniquindio.citashospital.citashospital;

    opens co.edu.uniquindio.citashospital.citashospital.viewController to javafx.fxml;
    exports co.edu.uniquindio.citashospital.citashospital.viewController;

    exports co.edu.uniquindio.citashospital.citashospital.model;
    exports co.edu.uniquindio.citashospital.citashospital.controller;

}