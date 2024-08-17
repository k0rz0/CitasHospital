package co.edu.uniquindio.citashospital.citashospital.factory;

import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Hospital;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;

import java.util.List;

public class ModelFactoryController {
    private static ModelFactoryController modelFactory;

    private Hospital hospital = Hospital.builder().nombre("San juan").build();

    private ModelFactoryController(){
        inicializarDatos();
    }

    public static  ModelFactoryController getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactoryController();
        }
        return modelFactory;
    }
    private void inicializarDatos() {}
    public List<Cita> obtenerCitas(){return hospital.getCitas();}
    public List<Doctor> obtenerDoctors() { return hospital.obtenerDoctores(); }
    public List<Paciente> obtenerPacientes() { return hospital.obtenerPacientes(); }
}
