package com.interview.notable;

import com.interview.notable.entities.Appointment;
import com.interview.notable.entities.Doctor;
import com.interview.notable.repositories.AppointmentRepository;
import com.interview.notable.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class Seeder implements CommandLineRunner {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public void run(String... args) throws Exception {
        Doctor doctor1 = new Doctor();

        doctor1.setFirstName("Doc");
        doctor1.setLastName("McStuffins");

        Doctor doctor2 = new Doctor();

        doctor2.setFirstName("Doc");
        doctor2.setLastName("Octopus");

        Doctor doctor3 = new Doctor();

        doctor3.setFirstName("Doc");
        doctor3.setLastName("FromBackToTheFuture");

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);

        Appointment appointment1 = new Appointment();

        appointment1.setPatientFirstName("Patient1");
        appointment1.setPatientLastName("Patient1LastName");
        appointment1.setDate("11/12/22");
        appointment1.setTime("10:00");
        appointment1.setKind("New Patient");

        Appointment appointment2 = new Appointment();

        appointment2.setPatientFirstName("Patient2");
        appointment2.setPatientLastName("Patient2LastName");
        appointment2.setDate("11/13/22");
        appointment2.setTime("11:00");
        appointment2.setKind("New Patient");

        Appointment appointment3 = new Appointment();

        appointment3.setPatientFirstName("Patient3");
        appointment3.setPatientLastName("Patient3LastName");
        appointment3.setDate("11/13/22");
        appointment3.setTime("12:00");
        appointment3.setKind("New Patient");

        Appointment appointment4 = new Appointment();

        appointment4.setPatientFirstName("Patient4");
        appointment4.setPatientLastName("Patient4LastName");
        appointment4.setDate("11/13/22");
        appointment4.setTime("13:15");
        appointment4.setKind("Follow-Up");

        List<Appointment> doc1appointments = new ArrayList<Appointment>();
        List<Appointment> doc2appointments = new ArrayList<Appointment>();

        doc1appointments.add(appointment1);
        doc1appointments.add(appointment2);
        doc1appointments.add(appointment3);

        doc2appointments.add(appointment4);

        doctor1.setAppointments(doc1appointments);
        doctor2.setAppointments(doc2appointments);

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);

        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);
        appointmentRepository.save(appointment4);

    }
}