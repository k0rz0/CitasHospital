package co.edu.uniquindio.citashospital.citashospital.mapping.mappers;

import co.edu.uniquindio.citashospital.citashospital.mapping.dto.DoctorDTO;
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
    DoctorDTO doctorToDoctorDTO(Doctor doctor);

    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);

    @IterableMapping(qualifiedByName = "doctorToDoctorDTO")
    List<DoctorDTO> getDoctorDTO(List<Doctor> listaDoctores);

    @Mapping(target = "nombrePaciente", source ="paciente.nombre")
    @IterableMapping(qualifiedByName = "citaToCitaDTO")
    Paciente pacienteToPacienteDTO(Paciente paciente);

}
