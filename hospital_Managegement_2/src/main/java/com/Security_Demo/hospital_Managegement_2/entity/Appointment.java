package com.Security_Demo.hospital_Managegement_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {  // appointments table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime appointmentTime;
    private String status; // SCHEDULED, COMPLETED, CANCELLED

    // appoint map to doc as Manytoone
    // ek appointment ke pass ek doc hoga jaroor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Appoint and patient map
    // ek appointment ke pass sirf ek patient hoga -> manyToone
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;


}
