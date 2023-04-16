package com.example.lab3_20200839.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer doctorId;

    @Column(name = "nombre", nullable = false)
    private String doctorNombre;

    @Column(name = "especialidad")
    private String doctorEspecialidad;
    @Column(name = "hospital_id")
    private Integer doctorHospital;

}
