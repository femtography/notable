package com.interview.notable.repositories;

import com.interview.notable.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findById(Long id);

    List<Appointment> findByDeletedFalse();

}
