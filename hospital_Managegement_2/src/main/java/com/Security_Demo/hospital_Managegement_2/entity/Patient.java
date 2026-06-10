package com.Security_Demo.hospital_Managegement_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Patient {  // ek patients table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String phone;
    private String disease;

    // patient ki appointment ke sath mapping
    // ek patient ki bahut appoinment hosakte hai -> one to many
    // ek patient ke pass appoint ki list hogi


    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JsonIgnore   // ← Ye add karo
    private List<Appointment> appointments = new ArrayList<>();

}
