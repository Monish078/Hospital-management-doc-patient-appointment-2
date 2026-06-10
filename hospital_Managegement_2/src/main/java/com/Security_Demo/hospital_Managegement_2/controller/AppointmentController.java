package com.Security_Demo.hospital_Managegement_2.controller;

import com.Security_Demo.hospital_Managegement_2.entity.Appointment;
import com.Security_Demo.hospital_Managegement_2.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/book") // ek appoint men create kare
    public ResponseEntity<Appointment> book(
            @RequestParam Long doctorId,
            @RequestParam Long patientId) {
        LocalDateTime dateTime = LocalDateTime.now();  // yahi time bana diya
        return ResponseEntity.ok(
                appointmentService.bookAppointment(doctorId, patientId, dateTime)
        );
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getByDoctor(@PathVariable Long doctorId) {
        return appointmentService.getByDoctor(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getByPatient(@PathVariable Long patientId) {
        return appointmentService.getByPatient(patientId);
    }

    @PatchMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id,
                                    @RequestParam String status) {
        return appointmentService.updateStatus(id, status);
    }
}
