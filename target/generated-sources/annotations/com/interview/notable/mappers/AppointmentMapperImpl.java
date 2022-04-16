package com.interview.notable.mappers;

import com.interview.notable.dtos.AppointmentRequestDto;
import com.interview.notable.dtos.AppointmentResponseDto;
import com.interview.notable.entities.Appointment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-16T12:42:26-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 18 (Homebrew)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentResponseDto entityToDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto();

        return appointmentResponseDto;
    }

    @Override
    public Appointment requestToEntity(AppointmentRequestDto appointmentRequestDto) {
        if ( appointmentRequestDto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        return appointment;
    }

    @Override
    public List<AppointmentResponseDto> entitiesToDtos(List<Appointment> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentResponseDto> list = new ArrayList<AppointmentResponseDto>( appointments.size() );
        for ( Appointment appointment : appointments ) {
            list.add( entityToDto( appointment ) );
        }

        return list;
    }

    @Override
    public Appointment responseToUser(AppointmentResponseDto appointment) {
        if ( appointment == null ) {
            return null;
        }

        Appointment appointment1 = new Appointment();

        return appointment1;
    }
}
