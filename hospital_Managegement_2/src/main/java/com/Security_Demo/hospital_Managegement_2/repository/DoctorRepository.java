package com.Security_Demo.hospital_Managegement_2.repository;

import com.Security_Demo.hospital_Managegement_2.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(String specialization);
}