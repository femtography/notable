package com.interview.notable.services;

import com.interview.notable.dtos.AppointmentRequestDto;
import com.interview.notable.dtos.AppointmentResponseDto;
import com.interview.notable.dtos.DoctorRequestDto;
import com.interview.notable.dtos.DoctorResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    ResponseEntity<List<DoctorResponseDto>> getAllDoctors();

    ResponseEntity<List<AppointmentResponseDto>> getDoctorsAppointmentsByDate(String date, DoctorRequestDto doctorRequestDto);

    ResponseEntity<AppointmentResponseDto> deleteDoctorsAppointment(Long appointmentId);

    ResponseEntity<AppointmentResponseDto> createDoctorsAppointment(AppointmentRequestDto appointmentRequestDto, DoctorRequestDto doctorRequestDto);

}
