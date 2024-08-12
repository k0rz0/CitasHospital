package co.edu.uniquindio.citashospital.citashospital.model.builder.persona;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;

public class DoctorBuilder extends PersonaBuilder<DoctorBuilder> {
    @Override
    protected DoctorBuilder self() {
        return this;
    }

    public Doctor build() {
        return new Doctor(cedula, nombre, apellido);
    }
}
