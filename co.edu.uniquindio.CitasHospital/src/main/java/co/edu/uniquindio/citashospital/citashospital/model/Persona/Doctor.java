package co.edu.uniquindio.citashospital.citashospital.model.Persona;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;
import co.edu.uniquindio.citashospital.citashospital.model.builder.persona.DoctorBuilder;

public class Doctor extends Persona {
    public Doctor(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
    }

}
