package com.Security_Demo.hospital_Managegement_2.repository;

import com.Security_Demo.hospital_Managegement_2.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDisease(String disease);
}