package co.edu.uniquindio.citashospital.citashospital.model.builder;

import co.edu.uniquindio.citashospital.citashospital.model.Hospital;

public class HospitalBuilder {
    protected String nombre;
    public HospitalBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public Hospital build() {return new Hospital(nombre);}
}
