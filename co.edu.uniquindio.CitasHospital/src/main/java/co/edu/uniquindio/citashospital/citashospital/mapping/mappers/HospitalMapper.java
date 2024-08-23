package co.edu.uniquindio.citashospital.citashospital.mapping.mappers;

import co.edu.uniquindio.citashospital.citashospital.mapping.dto.CitaDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.DoctorDTO;
import co.edu.uniquindio.citashospital.citashospital.mapping.dto.PacienteDTO;
import co.edu.uniquindio.citashospital.citashospital.model.Cita;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Doctor;
import co.edu.uniquindio.citashospital.citashospital.model.Persona.Paciente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HospitalMapper {
    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    @Named("doctorToDoctorDTO")
    @Mapping(target = "doctorNombre", source = "nombre")
    @Mapping(target = "doctorApellido", source = "apellido")
    @Mapping(target = "doctorCedula", source = "cedula")
    DoctorDTO doctorToDoctorDTO(Doctor doctor);

    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);

    @IterableMapping(qualifiedByName = "doctorToDoctorDTO")
    List<DoctorDTO> getDoctoresDTO(List<Doctor> listaDoctores);

    @Named("pacienteToPacienteDTO")
    @Mapping(target = "pacienteNombre", source = "nombre")
    @Mapping(target = "pacienteApellido", source = "apellido")
    @Mapping(target = "pacienteCedula", source = "cedula")
    @Mapping(target = "pacienteEps", source = "eps")
    PacienteDTO pacienteToPacienteDTO(Paciente paciente);

    Paciente pacienteDTOToPaciente(PacienteDTO pacienteDTO);

    @IterableMapping(qualifiedByName = "pacienteToPacienteDTO")
    List<PacienteDTO> getPacientesDTO(List<Paciente> listaPacientes);

    @Named("citaToCitaDTO")
    @Mapping(target = "citaId", source = "idCita")
    @Mapping(target = "citaDoctor", source = "doctorAsignado")
    @Mapping(target = "citaPaciente", source = "pacienteAsignado")
    @Mapping(target = "citaFecha", source = "fechaCita")
    CitaDTO citaToCitaDTO(Cita cita);

    Cita citaDTOToCita(CitaDTO citaDTO);

    @IterableMapping(qualifiedByName = "citaToCitaDTO")
    List<CitaDTO> getCitaDTO(List<Cita> listaCita);


}
