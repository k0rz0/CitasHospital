module co.edu.uniquindio.citashospital.citashospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.citashospital.citashospital to javafx.fxml;
    exports co.edu.uniquindio.citashospital.citashospital;

    opens co.edu.uniquindio.citashospital.citashospital.viewController;
    exports co.edu.uniquindio.citashospital.citashospital.viewController;

    opens co.edu.uniquindio.citashospital.citashospital.model;
    exports co.edu.uniquindio.citashospital.citashospital.model;

    opens co.edu.uniquindio.citashospital.citashospital.controller;
    exports co.edu.uniquindio.citashospital.citashospital.controller;

    exports co.edu.uniquindio.citashospital.citashospital.mapping.dto;
    exports co.edu.uniquindio.citashospital.citashospital.mapping.mappers;
}