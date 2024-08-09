package co.edu.uniquindio.citashospital.citashospital.viewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CitasViewController {
    @FXML
    private TableColumn<?, ?> colCodigoCita;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDoctor;

    @FXML
    private TableColumn<?, ?> colPaciente;

    @FXML
    private DatePicker dateCita;

    @FXML
    private MenuButton ddlDoctor;

    @FXML
    private MenuButton ddlPaciente;

    @FXML
    private TableView<?> tableCita;

    @FXML
    void onAddCita(ActionEvent event) {

    }
}
