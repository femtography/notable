package com.interview.notable.mappers;

import com.interview.notable.dtos.DoctorRequestDto;
import com.interview.notable.dtos.DoctorResponseDto;
import com.interview.notable.entities.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorResponseDto entityToDto(Doctor doctor);

    Doctor requestToEntity(DoctorRequestDto doctorRequestDto);

    List<DoctorResponseDto> entitiesToDtos(List<Doctor> doctors);

    Doctor responseToUser(DoctorResponseDto doctor);

}
