package co.edu.uniquindio.citashospital.citashospital.model.builder.persona;

import co.edu.uniquindio.citashospital.citashospital.model.Persona.Persona;

public class PersonaBuilder <T extends PersonaBuilder>{

    protected  String cedula;
    protected  String nombre;
    protected  String apellido;


    public T setCedula(String cedula) {
        this.cedula = cedula;
        return (T) this;
    }

    public T setNombre(String nombre) {
        this.nombre = nombre;
        return (T) this;
    }

    public T setApellido(String apellido) {
        this.apellido = apellido;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public Persona build() {
        return new Persona(cedula, nombre, apellido);
    }


}
