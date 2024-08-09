package co.edu.uniquindio.citashospital.citashospital.model.builder;

import co.edu.uniquindio.citashospital.citashospital.model.Doctor;

public class DoctorBuilder extends PersonaBuilder<DoctorBuilder>{
    @Override
    protected DoctorBuilder self() {
        return this;
    }

    public Doctor build() {
        return new Doctor(cedula, nombre, apellido);
    }
}
