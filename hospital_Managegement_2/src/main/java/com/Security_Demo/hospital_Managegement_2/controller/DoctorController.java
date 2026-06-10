package com.Security_Demo.hospital_Managegement_2.controller;

import com.Security_Demo.hospital_Managegement_2.entity.Doctor;
import com.Security_Demo.hospital_Managegement_2.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;


    @PostMapping  // new doc add karo
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.addDoctor(doctor));
    }

    @GetMapping  // all doc
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }


    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,
                               @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted!");
    }

    @GetMapping("/specialization/{spec}")
    public List<Doctor> getBySpec(@PathVariable String spec) {
        return doctorService.getBySpecialization(spec);
    }

}
