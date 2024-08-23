package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;

import java.util.*;

public class Hospital {

    private String nombre;

    private Map<String, List<Persona>> personasPorTipo;// Este funciona para almacenar todas la personas en una sola lista en una matriz
//    ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Doctor> doctores = new ArrayList<>();
    ArrayList<Cita> citas = new ArrayList<>();

    //Constructor
    public Hospital(String nombre) {
        this.nombre = nombre;
    }

    public Hospital() {
        personasPorTipo = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<Doctor> obtenerDoctores(){
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
    public void agregarCita(Cita cita){
        citas.add(cita);
    }

    public boolean verificarCitaExistente(String doctorAsignado, String pacienteAsignado, Date fechaCita) {
        return citas.stream().anyMatch(c ->
                c.getDoctorAsignado().equals(doctorAsignado) &&
                        c.getPacienteAsignado().equals(pacienteAsignado) &&
                        c.getFechaCita().equals(fechaCita));
    }
}
