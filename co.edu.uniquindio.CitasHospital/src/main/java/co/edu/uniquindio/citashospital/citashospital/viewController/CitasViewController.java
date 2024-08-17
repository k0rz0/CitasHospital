package co.edu.uniquindio.citashospital.citashospital.viewController;
import co.edu.uniquindio.citashospital.citashospital.controller.CitaController;
import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class CitasViewController {
    CitaController citaController;
    Cita citaSeleccionado;
    ObservableList<Cita> listCita = FXCollections.observableArrayList();
    private boolean isUpdatingList = false;

    @FXML
    void initialize() {
        citaController = new CitaController();
        initCombo();
        initTable();
        initSearch();
    }
    private void initTable() {

        initDataBinding();
        obtenerCita();
        tableCita.getItems().clear();
        tableCita.setItems(listCita);
        listenerSelection();
    }
    private void initDataBinding() {
        colDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCita().toString()));
        colDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDoctorAsignado().getCedula()));
        colPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPacienteAsignado().getCedula()));
        colCodigoCita.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdCita())));
    }
    private void initSearch(){

        FilteredList<Cita> filteredData = new FilteredList<>(listCita, b->true);
        txtBuscarCita.textProperty().addListener((ObservableList,oldValue,newValue)->{
            filteredData.setPredicate(citaSeleccionado ->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String loweCaseFilter = newValue.toLowerCase();
                if (String.valueOf(citaSeleccionado.getIdCita()).toLowerCase().contains(loweCaseFilter)) {
                    return true;
                } else if (citaSeleccionado.getDoctorAsignado().getCedula().toLowerCase().contains(loweCaseFilter)){
                    return true;
                }
                return citaSeleccionado.getPacienteAsignado().getCedula().toLowerCase().contains(loweCaseFilter);
            });
        });
        SortedList<Cita> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableCita.comparatorProperty());
        tableCita.setItems(sortedData);
    }
    private void obtenerCita() {
        listCita.clear();
        listCita.addAll(citaController.obtenerCitas());
    }
    private void listenerSelection() {
        tableCita.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            citaSeleccionado = newSelection;
            mostrarInformacionCita(citaSeleccionado);
        });
    }
    private void mostrarInformacionCita(Cita citaSeleccionada) {
        if(citaSeleccionada != null){
            cbDoctor.getSelectionModel().select(citaSeleccionada.getDoctorAsignado().getCedula());
            cbPaciente.getSelectionModel().select(citaSeleccionada.getDoctorAsignado().getCedula());
            dateCita.setValue(citaSeleccionada.getFechaCita().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
    }
    private void initCombo() {
        initCbDoctor();
        initCbPaciente();

    }
    private void  initCbDoctor(){
        ObservableList<String> cbDoctores = FXCollections.observableArrayList();
        List<Doctor> listDoctor = citaController.obtenerDoctores();
        cbDoctores.addAll("--Seleccione--");
        for (Doctor doctor:listDoctor){
            cbDoctores.add(doctor.getCedula());
        }
        cbDoctor.setItems(cbDoctores);
        cbDoctor.getSelectionModel().select("--Seleccione--");
    }
    private void  initCbPaciente(){
        ObservableList<String> itemscbPacientes = FXCollections.observableArrayList();
        List<Paciente> listPacientes = citaController.obtenerPacientes();
        itemscbPacientes.addAll("--Seleccione--");
        for (Paciente paciente:listPacientes){
            itemscbPacientes.add(paciente.getCedula());
        }
        cbPaciente.setItems(itemscbPacientes);
        cbDoctor.getSelectionModel().select("--Seleccione--");
    }



    @FXML
    private TableColumn<Cita, String> colCodigoCita;

    @FXML
    private TableColumn<Cita, String> colDate;

    @FXML
    private TableColumn<Cita, String> colDoctor;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private DatePicker dateCita;

    @FXML
    private ComboBox<String> cbDoctor;

    @FXML
    private ComboBox<String> cbPaciente;

    @FXML
    private TableView<Cita> tableCita;

    @FXML
    private TextField txtBuscarCita;

    @FXML
    void onAddCita(ActionEvent event) {
    }

}
