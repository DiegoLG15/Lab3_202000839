package com.example.lab3_20200839.repository;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByDoctorHospital(int doctorHospital);



}
