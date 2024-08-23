package co.edu.uniquindio.citashospital.citashospital.utils;

import co.edu.uniquindio.citashospital.citashospital.model.Hospital;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;

import java.util.Date;

public class HospitalUtils {
    public static Hospital inicilizarDatos(){
        Hospital hospital = new Hospital();
        hospital.setNombre("San Juan");

// Creación de pacientes y doctores sin builder
        Paciente paciente = new Paciente();
        paciente.setCedula("12131");
        paciente.setNombre("Pablo");
        paciente.setApellido("Gonzales");
        paciente.setEps("Sura");
        hospital.agregarPersona(paciente);

        Doctor doctor = new Doctor();
        doctor.setNombre("Maria Jose");
        doctor.setApellido("Angulo");
        doctor.setCedula("1213141");
        hospital.agregarPersona(doctor);

        Paciente paciente1 = new Paciente();
        paciente1.setCedula("12345");
        paciente1.setNombre("Luis");
        paciente1.setApellido("Martinez");
        paciente1.setEps("Coomeva");
        hospital.agregarPersona(paciente1);

        Doctor doctor1 = new Doctor();
        doctor1.setNombre("Carlos");
        doctor1.setApellido("Fernandez");
        doctor1.setCedula("54321");
        hospital.agregarPersona(doctor1);

        Paciente paciente2 = new Paciente();
        paciente2.setCedula("67890");
        paciente2.setNombre("Ana");
        paciente2.setApellido("Rodriguez");
        paciente2.setEps("Sanitas");
        hospital.agregarPersona(paciente2);

        Doctor doctor2 = new Doctor();
        doctor2.setNombre("Lucia");
        doctor2.setApellido("Vargas");
        doctor2.setCedula("98765");
        hospital.agregarPersona(doctor2);

        Paciente paciente3 = new Paciente();
        paciente3.setCedula("13579");
        paciente3.setNombre("Pedro");
        paciente3.setApellido("Ramirez");
        paciente3.setEps("Nueva EPS");
        hospital.agregarPersona(paciente3);

        Doctor doctor3 = new Doctor();
        doctor3.setNombre("Javier");
        doctor3.setApellido("Lopez");
        doctor3.setCedula("97531");
        hospital.agregarPersona(doctor3);

        System.out.println("Melo base");
        return hospital;
    }
}
