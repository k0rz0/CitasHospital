package co.edu.uniquindio.citashospital.citashospital.model.builder.persona;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;

public class PacienteBuilder extends PersonaBuilder<PacienteBuilder> {
    protected String eps;
    @Override
    protected PacienteBuilder self() {
        return this;
    }

    public Paciente build() {
        return new Paciente(cedula, nombre, apellido, eps);
    }
}
