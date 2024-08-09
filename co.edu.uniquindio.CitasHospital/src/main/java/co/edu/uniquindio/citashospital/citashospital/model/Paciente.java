package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.builder.PacienteBuilder;

public class Paciente extends Persona {

    private  String eps;

    public Paciente(String cedula, String nombre, String apellido, String eps) {
        super(cedula, nombre, apellido);
        this.eps = eps;
    }

    public static PacienteBuilder builder() {
        return new PacienteBuilder();
    }

}
