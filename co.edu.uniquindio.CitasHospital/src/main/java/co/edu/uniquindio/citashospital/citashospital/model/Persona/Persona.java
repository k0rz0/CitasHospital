package co.edu.uniquindio.citashospital.citashospital.model.Persona;

import co.edu.uniquindio.citashospital.citashospital.model.builder.persona.PersonaBuilder;

public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;

    public Persona(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static PersonaBuilder builder() {return new PersonaBuilder();}

    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

}
