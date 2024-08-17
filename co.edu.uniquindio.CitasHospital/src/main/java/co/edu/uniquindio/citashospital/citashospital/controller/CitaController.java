package co.edu.uniquindio.citashospital.citashospital.controller;

import co.edu.uniquindio.citashospital.citashospital.factory.ModelFactoryController;
import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CitaController {
    ModelFactoryController modelFactory;

    public CitaController() {
        modelFactory = ModelFactoryController.getInstance();
    }
    public List<Doctor> obtenerDoctores() {
        List<Doctor> doctors = modelFactory.obtenerDoctors();
        return doctors;
    }
    public List<Paciente> obtenerPacientes() {
        List<Paciente> paciente = modelFactory.obtenerPacientes();
        return paciente;
    }

    public List<Cita> obtenerCitas() {
       List<Cita> citas = modelFactory.obtenerCitas();
        return citas;
    }
}
