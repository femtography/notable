package com.interview.notable.controllers;

import com.interview.notable.dtos.AppointmentRequestDto;
import com.interview.notable.dtos.AppointmentResponseDto;
import com.interview.notable.dtos.DoctorRequestDto;
import com.interview.notable.dtos.DoctorResponseDto;
import com.interview.notable.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class TheController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {

        return doctorService.getAllDoctors();

    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> getAllDoctorsAppointmentsByDate(@RequestBody String date, @RequestBody DoctorRequestDto doctorRequestDto) {

        return doctorService.getDoctorsAppointmentsByDate(date, doctorRequestDto);

    }

    @DeleteMapping
    public ResponseEntity<AppointmentResponseDto> deleteTweet(@RequestBody Long appointmentId) {
        return doctorService.deleteDoctorsAppointment(appointmentId);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto, @RequestBody DoctorRequestDto doctorRequestDto) {

        return doctorService.createDoctorsAppointment(appointmentRequestDto, doctorRequestDto);

    }

}
