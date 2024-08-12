package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;
import co.edu.uniquindio.citashospital.citashospital.model.builder.HospitalBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Persona productoEncontrado = obtenerPersonaPorCedula(nuevaPersona.getCedula());
        if (productoEncontrado == null) {
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

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
