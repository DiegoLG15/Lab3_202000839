package com.example.lab3_20200839.repository;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByHospitalPaciente(int pacienteHospital);
    List<Paciente> findByDoctorPaciente(int doctorPaciente);
    List<Paciente> findByDoctorPacienteAndFechaCitaAfter(int doctorPaciente,String fechaLimite);

}
