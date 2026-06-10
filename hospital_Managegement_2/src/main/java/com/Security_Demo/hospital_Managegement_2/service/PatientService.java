package com.Security_Demo.hospital_Managegement_2.service;

import com.Security_Demo.hospital_Managegement_2.entity.Patient;
import com.Security_Demo.hospital_Managegement_2.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {  ///  ad new patient ke liye
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {  // sare patient ke liye
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {  // get paiient is de
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient nahi mila! ID: " + id));
    }

    public Patient updatePatient(Long id, Patient updated) {
        Patient patient = getPatientById(id);
        patient.setName(updated.getName());
        patient.setAge(updated.getAge());
        patient.setPhone(updated.getPhone());
        patient.setDisease(updated.getDisease());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        getPatientById(id);
        patientRepository.deleteById(id);
    }


}
