package com.example.lab3_20200839.repository;

import com.example.lab3_20200839.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
