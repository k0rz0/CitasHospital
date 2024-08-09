package co.edu.uniquindio.citashospital.citashospital.model;

import co.edu.uniquindio.citashospital.citashospital.model.builder.DoctorBuilder;

public class Doctor extends Persona {
    public Doctor(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
    }

}
