package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;
import co.edu.uniquindio.citashospital.citashospital.model.builder.HospitalBuilder;

import java.util.*;

public class Hospital {

    private String nombre;

    private Map<String, List<Persona>> personasPorTipo;// Este funciona para almacenar todas la personas en una sola lista en una matriz
//    ArrayList<Paciente> pacientes = new ArrayList<>();
//    ArrayList<Doctor> doctores = new ArrayList<>();
    ArrayList<Cita> citas = new ArrayList<>();

    //Constructor
    public Hospital(String nombre) {
        this.nombre = nombre;
        personasPorTipo = new HashMap<>();
    }
    //Builder
    public static HospitalBuilder builder(){
        return new HospitalBuilder();
    }

    public Persona obtenerPersonaPorCedula(String cedulaPersona) {
        for (List<Persona> listaPersona : personasPorTipo.values()) {
            for (Persona persona : listaPersona) {
                if (persona.getCedula().equals(cedulaPersona)) {
                    return persona;
                }
            }
        }
        return null;
    }
    public boolean agregarPersona(Persona nuevaPersona) {
        Persona personaEncontrado = obtenerPersonaPorCedula(nuevaPersona.getCedula());
        if (personaEncontrado == null) {
            String tipoPersona = nuevaPersona.getClass().getSimpleName();
            if (!personasPorTipo.containsKey(tipoPersona)) {
                personasPorTipo.put(tipoPersona, new ArrayList<>());
            }
            personasPorTipo.get(tipoPersona).add(nuevaPersona);
            return true;
        }else{
            return  false;
        }
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public  List<Persona> obtenerPersonasPorTipo(String tipoPersona) {
        return personasPorTipo.getOrDefault(tipoPersona,new ArrayList<>());
    }
    public  List<Doctor> obtenerDoctores(){
        List<Persona> personas = obtenerPersonasPorTipo("Doctor");
        List<Doctor> doctors = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Doctor) {
                doctors.add((Doctor) persona);
            }
        }
        return doctors;
    }
    public  List<Paciente> obtenerPacientes(){
        List<Persona> personas = obtenerPersonasPorTipo("Paciente");
        List<Paciente> pacientes = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Paciente) {
                pacientes.add((Paciente) persona);
            }
        }
        return pacientes;
    }
    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
