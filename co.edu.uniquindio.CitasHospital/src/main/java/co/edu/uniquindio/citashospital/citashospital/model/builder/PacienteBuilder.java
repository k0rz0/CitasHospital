package co.edu.uniquindio.citashospital.citashospital.model.builder;

import co.edu.uniquindio.citashospital.citashospital.model.Paciente;

public class PacienteBuilder extends PersonaBuilder<PacienteBuilder>{
    protected String eps;
    @Override
    protected PacienteBuilder self() {
        return this;
    }

    public Paciente build() {
        return new Paciente(cedula, nombre, apellido, eps);
    }
}
