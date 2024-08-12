package co.edu.uniquindio.citashospital.citashospital.model.Persona;

import co.edu.uniquindio.citashospital.citashospital.model.builder.persona.PacienteBuilder;

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
