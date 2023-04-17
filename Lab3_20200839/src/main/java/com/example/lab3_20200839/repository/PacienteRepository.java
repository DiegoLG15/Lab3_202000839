package com.example.lab3_20200839.repository;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospitalPaciente(int pacienteHospital);
    List<Paciente> findByDoctorPaciente(int doctorPaciente);
    List<Paciente> findByDoctorPacienteAndFechaCitaAfter(int doctorPaciente,String fechaLimite);

    @Modifying
    @Transactional
    @Query (nativeQuery = true, value = "UPDATE paciente SET doctor_id = ?2 WHERE doctor_id = ?1")
    void actualizarPaciente(Integer id1,Integer id2);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE paciente SET numero_habitacion = ?2 WHERE id = ?1")
    void actualizarHabitacion(Integer id, Integer numeroHabtacion);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE paciente SET hospital_id = ?2 WHERE hospital_id = ?1 and doctor_id = ?3")
    void derivarPaciente(Integer i1, Integer id2, Integer id3);



}
