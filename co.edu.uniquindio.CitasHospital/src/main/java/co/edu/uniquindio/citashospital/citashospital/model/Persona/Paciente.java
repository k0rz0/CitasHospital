package co.edu.uniquindio.citashospital.citashospital.model.Persona;


public class Paciente extends Persona {

    private  String eps;

    public Paciente(String cedula, String nombre, String apellido, String eps) {
        super(cedula, nombre, apellido);
        this.eps = eps;
    }

    public Paciente() {
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
