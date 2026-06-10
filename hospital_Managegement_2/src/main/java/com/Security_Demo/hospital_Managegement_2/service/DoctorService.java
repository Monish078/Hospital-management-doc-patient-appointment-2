package com.Security_Demo.hospital_Managegement_2.service;

import com.Security_Demo.hospital_Managegement_2.entity.Doctor;
import com.Security_Demo.hospital_Managegement_2.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

     private final DoctorRepository doctorRepository;


    public Doctor addDoctor(Doctor doctor) {  // ek doc ko save karne ke liye
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() { // sare docs ko print ke liye
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) { // doc by id
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor nahi mila! ID: " + id));
    }

    public void deleteDoctor(Long id) {  // delete doct id se
        getDoctorById(id);
        doctorRepository.deleteById(id);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        // pehle doc find karo
        Doctor doctor = getDoctorById(id);
        // update
        doctor.setName(updatedDoctor.getName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        doctor.setPhone(updatedDoctor.getPhone());

        return doctorRepository.save(doctor);
    }

    // doc by specialization
    public List<Doctor> getBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }



}
