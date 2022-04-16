package com.interview.notable.services.impl;

import com.interview.notable.dtos.AppointmentRequestDto;
import com.interview.notable.dtos.AppointmentResponseDto;
import com.interview.notable.dtos.DoctorRequestDto;
import com.interview.notable.dtos.DoctorResponseDto;
import com.interview.notable.entities.Appointment;
import com.interview.notable.entities.Doctor;
import com.interview.notable.mappers.AppointmentMapper;
import com.interview.notable.mappers.DoctorMapper;
import com.interview.notable.repositories.AppointmentRepository;
import com.interview.notable.repositories.DoctorRepository;
import com.interview.notable.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    private final DoctorService doctorService;

    private final DoctorMapper doctorMapper;
    private final AppointmentMapper appointmentMapper;

    @Override
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {

        List<Doctor> doctorList = new ArrayList<>(doctorRepository.findAll());

        return new ResponseEntity<>(doctorMapper.entitiesToDtos(doctorList), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<AppointmentResponseDto>> getDoctorsAppointmentsByDate(String date, DoctorRequestDto doctorRequestDto) {

        Doctor doctor = doctorMapper.requestToEntity(doctorRequestDto);
        List<Appointment> appointmentList = new ArrayList<>();

        for (Appointment appointment: doctor.getAppointments()) {
            if (appointment.getDate().equals(date)) {
                appointmentList.add(appointment);
            }
        }

        if (appointmentList.size() > 0) {
            return new ResponseEntity<>(appointmentMapper.entitiesToDtos(appointmentList), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<AppointmentResponseDto> deleteDoctorsAppointment(Long appointmentId) {

        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);

        if (appointment.isPresent() && !appointment.get().isDeleted()) {

            ResponseEntity<AppointmentResponseDto> response = new ResponseEntity<>(appointmentMapper.entityToDto(appointment.get()), HttpStatus.OK);

            appointment.get().setDeleted(true);
            appointmentRepository.saveAndFlush(appointment.get());

            return response;

        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<AppointmentResponseDto> createDoctorsAppointment(AppointmentRequestDto appointmentRequestDto, DoctorRequestDto doctorRequestDto){

        // Make sure and come back to implement logic based on intervals and max amount of appointments per slot (3)
        // Sorry this is a mess, time crunch and all

        Doctor doctor = doctorMapper.requestToEntity(doctorRequestDto);
        Appointment appointment = appointmentMapper.requestToEntity(appointmentRequestDto);
        int counter = 0;
        String ending = appointment.getTime();
        ending.substring(4);

        if (!ending.contains("00") || ending.contains("15") || ending.contains("30") || ending.contains("40")) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        for (Appointment app: doctor.getAppointments()) {
            if (app.getDate().equals(appointment.getDate())) {
                counter++;
            }
        }

        if (counter > 2) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        if (doctor.getAppointments().add(appointment)) {

            return new ResponseEntity<>(appointmentMapper.entityToDto(appointment), HttpStatus.OK);

        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

}
