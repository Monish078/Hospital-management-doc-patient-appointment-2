package com.Security_Demo.hospital_Managegement_2.service;

import com.Security_Demo.hospital_Managegement_2.entity.Appointment;
import com.Security_Demo.hospital_Managegement_2.entity.Doctor;
import com.Security_Demo.hospital_Managegement_2.entity.Patient;
import com.Security_Demo.hospital_Managegement_2.repository.AppointmentRepository;
import com.Security_Demo.hospital_Managegement_2.repository.DoctorRepository;
import com.Security_Demo.hospital_Managegement_2.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    // ek appointment creaton ke liye
    public Appointment bookAppointment(Long doctorId,
                                       Long patientId,
                                       LocalDateTime time) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor nahi mila"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient nahi mila"));

        Appointment apt = new Appointment();
        apt.setDoctor(doctor);
        apt.setPatient(patient);
        apt.setAppointmentTime(time);
        apt.setStatus("SCHEDULED");

        return appointmentRepository.save(apt);
    }

    // all apointment ke liye
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // update status of appointment using appoint id
    public Appointment updateStatus(Long id, String status) {
        Appointment apt = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment nahi mili"));
        apt.setStatus(status);
        return appointmentRepository.save(apt);
    }


    public List<Appointment> getByDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor nahi mila! ID: " + doctorId));
        return doctor.getAppointments();
    }

    public List<Appointment> getByPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient nahi mila! ID: " + patientId));


        return patient.getAppointments();
    }
}
