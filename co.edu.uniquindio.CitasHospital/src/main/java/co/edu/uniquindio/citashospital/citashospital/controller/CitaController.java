package co.edu.uniquindio.citashospital.citashospital.controller;

import co.edu.uniquindio.citashospital.citashospital.factory.ModelFactoryController;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.CitaDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.DoctorDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.PacienteDTO;
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
    public List<DoctorDTO> obtenerDoctores() {
        return modelFactory.obtenerDoctores();
    }
    public List<PacienteDTO> obtenerPacientes() {
        return modelFactory.obtenerPacientes();
    }
    public boolean agregarCita(CitaDTO citaDTO){
        return modelFactory.agregarCita(citaDTO);
    }

    public List<CitaDTO> obtenerCitas() {
       List<CitaDTO> citas = modelFactory.obtenerCitas();
        return citas;
    }
}
