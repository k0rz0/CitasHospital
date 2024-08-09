package co.edu.uniquindio.citashospital.citashospital;

import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Paciente;
import java.util.ArrayList;

public class Hospital {

    private String nombre;
    ArrayList<Paciente> pacientes = new ArrayList<>();
    ArrayList<Doctor> doctores = new ArrayList<>();

    ArrayList<Cita> citas = new ArrayList<>();

    public Hospital() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
