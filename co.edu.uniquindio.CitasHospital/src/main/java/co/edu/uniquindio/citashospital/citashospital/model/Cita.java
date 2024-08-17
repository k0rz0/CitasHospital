package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;

import java.time.LocalDate;
import java.util.Date;

public class Cita {
    private static int contador;
    private int idCita;
    private Doctor doctorAsignado;
    private Paciente pacienteAsignado;
    private Date fechaCita;

    public Cita(Doctor doctorAsignado, Paciente pacienteAsignado, Date fechaCita) {
        this.idCita = contador++;
        this.doctorAsignado = doctorAsignado;
        this.pacienteAsignado = pacienteAsignado;
        this.fechaCita = fechaCita;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public int getIdCita() {
        return idCita;
    }
}
