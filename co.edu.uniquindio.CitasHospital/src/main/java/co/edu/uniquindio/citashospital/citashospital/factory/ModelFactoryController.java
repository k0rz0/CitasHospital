package co.edu.uniquindio.citashospital.citashospital.factory;

import co.edu.uniquindio.citashospital.citashospital.mapping.dto.CitaDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.DoctorDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.PacienteDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.mappers.HospitalMapper;
import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Hospital;
import co.edu.uniquindio.citashospital.citashospital.utils.HospitalUtils;

import java.util.List;

public class ModelFactoryController {
    Hospital hospital;
    HospitalMapper mapper = HospitalMapper.INSTANCE;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        cargarDatosBase();
    }
    private void cargarDatosBase() {
        hospital = HospitalUtils.inicilizarDatos();
    }

    public List<CitaDTO> obtenerCitas(){

        return mapper.getCitaDTO(hospital.getCitas());}
    public List<DoctorDTO> obtenerDoctores() {return mapper.getDoctoresDTO(hospital.obtenerDoctores());}
    public List<PacienteDTO> obtenerPacientes() { return mapper.getPacientesDTO(hospital.obtenerPacientes()); }
    public boolean agregarCita(CitaDTO citaDTO){
        boolean agregado = false;

        if (!hospital.verificarCitaExistente(citaDTO.citaDoctor(), citaDTO.citaPaciente(), citaDTO.citaFecha())) {
            Cita cita = new Cita();
            cita.setDoctorAsignado(citaDTO.citaDoctor());
            cita.setPacienteAsignado(citaDTO.citaPaciente());
            cita.setFechaCita(citaDTO.citaFecha());
            hospital.agregarCita(cita);
            agregado = true;
        }
        return agregado;
    }
}
