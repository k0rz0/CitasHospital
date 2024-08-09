module co.edu.uniquindio.citashospital.citashospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.citashospital.citashospital to javafx.fxml;
    exports co.edu.uniquindio.citashospital.citashospital;
}