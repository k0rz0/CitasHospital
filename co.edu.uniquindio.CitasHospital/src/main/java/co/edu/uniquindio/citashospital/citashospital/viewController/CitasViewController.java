package co.edu.uniquindio.citashospital.citashospital.viewController;
import co.edu.uniquindio.citashospital.citashospital.controller.CitaController;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.CitaDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.DoctorDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.PacienteDTO;
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
import java.util.Date;
import java.util.List;

public class CitasViewController {
    CitaController citaController;
    CitaDTO citaSeleccionado;
    ObservableList<CitaDTO> listCita = FXCollections.observableArrayList();
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
        colDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().citaFecha().toString()));
        colDoctor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().citaDoctor()));
        colPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().citaPaciente()));
        colCodigoCita.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().citaId())));
    }
    private void initSearch(){

        FilteredList<CitaDTO> filteredData = new FilteredList<>(listCita, b->true);
        txtBuscarCita.textProperty().addListener((ObservableList,oldValue,newValue)->{
            filteredData.setPredicate(citaSeleccionado ->{
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String loweCaseFilter = newValue.toLowerCase();
                if (citaSeleccionado.citaDoctor().toLowerCase().contains(loweCaseFilter)){
                    return true;
                }
                return citaSeleccionado.citaPaciente().toLowerCase().contains(loweCaseFilter);
            });
        });
        SortedList<CitaDTO> sortedData = new SortedList<>(filteredData);
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
    private void mostrarInformacionCita(CitaDTO citaSeleccionada) {
        if(citaSeleccionada != null){
            cbDoctor.getSelectionModel().select(citaSeleccionada.citaDoctor());
            cbPaciente.getSelectionModel().select(citaSeleccionada.citaPaciente());
            dateCita.setValue(citaSeleccionada.citaFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
    }
    private void initCombo() {
        initCbDoctor();
        initCbPaciente();
    }
    private void  initCbDoctor(){
        ObservableList<String> cbDoctores = FXCollections.observableArrayList();
        List<DoctorDTO> listDoctor = citaController.obtenerDoctores();
        cbDoctores.addAll("--Seleccione--");
        for (DoctorDTO doctor:listDoctor){
            System.out.println(doctor);
            cbDoctores.add(doctor.doctorCedula());
        }
        cbDoctor.setItems(cbDoctores);
        cbDoctor.getSelectionModel().select("--Seleccione--");
    }
    private void  initCbPaciente(){
        ObservableList<String> itemscbPacientes = FXCollections.observableArrayList();
        List<PacienteDTO> listPacientes = citaController.obtenerPacientes();
        itemscbPacientes.addAll("--Seleccione--");
        for (PacienteDTO paciente:listPacientes){
            itemscbPacientes.add(paciente.pacienteCedula());
        }
        cbPaciente.setItems(itemscbPacientes);
        cbPaciente.getSelectionModel().select("--Seleccione--");
    }
    @FXML
    void onAddCita(ActionEvent event) {
        agregarCitaDTO();
    }
    private void agregarCitaDTO(){
        try {
            if (datosValidos()){
                CitaDTO citaDTO = contruirCitaDTO();
                if (citaController.agregarCita(citaDTO)){
                    obtenerCita();
                    limpiarCamposCita();
                }else {
                    // Manejar caso donde no se pudo agregar la cita
                    System.out.println("No se pudo agregar la cita.");
                }
            } else {
                System.out.println("Los datos ingresados no son válidos.");
            }
        }  catch (Exception e) {
        // Manejar cualquier excepción inesperada
            System.out.println("Ocurrió un error al intentar agregar la cita: " + e.getMessage());
        }
    }


    private void limpiarCamposCita() {
        cbDoctor.getSelectionModel().select("--Seleccione--");
        cbPaciente.getSelectionModel().select("--Seleccione--");
        dateCita.setValue(null);
    }

    private boolean datosValidos() {
        return !cbDoctor.getValue().equalsIgnoreCase("--Seleccione--")
                && !cbDoctor.getValue().equalsIgnoreCase("--Seleccione--")
                &&  dateCita.getValue() != null;
    }

    private CitaDTO contruirCitaDTO() {
        return new CitaDTO(0,cbDoctor.getValue(),cbPaciente.getValue(), Date.from(dateCita.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @FXML
    private TableColumn<CitaDTO, String> colCodigoCita;

    @FXML
    private TableColumn<CitaDTO, String> colDate;

    @FXML
    private TableColumn<CitaDTO, String> colDoctor;

    @FXML
    private TableColumn<CitaDTO, String> colPaciente;

    @FXML
    private DatePicker dateCita;

    @FXML
    private ComboBox<String> cbDoctor;

    @FXML
    private ComboBox<String> cbPaciente;

    @FXML
    private TableView<CitaDTO> tableCita;

    @FXML
    private TextField txtBuscarCita;



}
