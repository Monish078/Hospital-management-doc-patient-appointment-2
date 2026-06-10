package com.Security_Demo.hospital_Managegement_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {  // ek doctors table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String phone;

    // doct ki appoinments ki sath mapping one to many hai
    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,  // doc pe change hone se appoin bhi change hogi
            fetch = FetchType.LAZY  // lazy fetch type jisse sifr doc data load appoin nhi turant
    )
    @JsonIgnore   // ← Ye bhi add karo
    private List<Appointment> appointments = new ArrayList<>(); // ek doc pe appoint ki list hogi


}
