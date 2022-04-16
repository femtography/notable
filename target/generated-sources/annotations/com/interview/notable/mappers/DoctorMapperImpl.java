package com.interview.notable.mappers;

import com.interview.notable.dtos.DoctorRequestDto;
import com.interview.notable.dtos.DoctorResponseDto;
import com.interview.notable.entities.Doctor;
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
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponseDto entityToDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

        return doctorResponseDto;
    }

    @Override
    public Doctor requestToEntity(DoctorRequestDto doctorRequestDto) {
        if ( doctorRequestDto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        return doctor;
    }

    @Override
    public List<DoctorResponseDto> entitiesToDtos(List<Doctor> doctors) {
        if ( doctors == null ) {
            return null;
        }

        List<DoctorResponseDto> list = new ArrayList<DoctorResponseDto>( doctors.size() );
        for ( Doctor doctor : doctors ) {
            list.add( entityToDto( doctor ) );
        }

        return list;
    }

    @Override
    public Doctor responseToUser(DoctorResponseDto doctor) {
        if ( doctor == null ) {
            return null;
        }

        Doctor doctor1 = new Doctor();

        return doctor1;
    }
}
