package com.example.lab3_20200839.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name="hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hospitalId;

    @Column(name = "nombre", nullable = false)
    private String hospitalNombre;

    @Column(name = "direccion")
    private String hospitalDireccion;

    @Column(name = "telefono")
    private String hospitalTelefono;

}

