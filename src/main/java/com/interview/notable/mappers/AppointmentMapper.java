package com.interview.notable.mappers;

import com.interview.notable.dtos.AppointmentRequestDto;
import com.interview.notable.dtos.AppointmentResponseDto;
import com.interview.notable.entities.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentResponseDto entityToDto(Appointment appointment);

    Appointment requestToEntity(AppointmentRequestDto appointmentRequestDto);

    List<AppointmentResponseDto> entitiesToDtos(List<Appointment> appointments);

    Appointment responseToUser(AppointmentResponseDto appointment);
}
