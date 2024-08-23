package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;

import java.time.LocalDate;
import java.util.Date;

public class Cita {
    private static int contador;
    private int idCita;
    private String doctorAsignado;
    private String pacienteAsignado;
    private Date fechaCita;

    public Cita(String doctorAsignado, String pacienteAsignado, Date fechaCita) {
        this.doctorAsignado = doctorAsignado;
        this.pacienteAsignado = pacienteAsignado;
        this.fechaCita = fechaCita;
    }

    public void setDoctorAsignado(String doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public void setPacienteAsignado(String pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Cita(){
        this.idCita = ++contador;
    }

    public String getDoctorAsignado() {
        return doctorAsignado;
    }

    public String getPacienteAsignado() {
        return pacienteAsignado;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public int getIdCita() {
        return idCita;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", doctorAsignado='" + doctorAsignado + '\'' +
                ", pacienteAsignado='" + pacienteAsignado + '\'' +
                ", fechaCita=" + fechaCita +
                '}';
    }
}
