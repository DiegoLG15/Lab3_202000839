package com.example.lab3_20200839.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int pacienteId;

    @Column(name = "nombre",nullable = false)
    private String nombrePaciente;

    @Column(name = "edad")
    private int edadPaceinte;

    @Column(name = "genero")
    private String generoPaciente;

    @Column(name = "diagnostico")
    private String diagnosticoPaciente;


    @Column(name = "fecha_cita")
    private String fechaCita;

    @Column(name = "numero_habitacion")
    private int habitacionPaciente;

    @Column(name = "doctor_id")
    private int doctorPaciente;

    @Column(name = "hospital_id")
    private int hospitalPaciente;

}
