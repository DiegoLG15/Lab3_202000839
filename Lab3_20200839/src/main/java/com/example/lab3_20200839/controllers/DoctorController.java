package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Paciente;
import com.example.lab3_20200839.repository.DoctorRepository;
import com.example.lab3_20200839.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller

public class DoctorController {

    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    public DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping(value = {"/listaDoctores"})
    public String listarDoctores(Model model) {
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listDoctor", lista);
        return "doctor/list";
    }
    @GetMapping("/doctorPaciente")
    public String mostrarPacientes(@RequestParam("id") Integer id, Model model) {

        List<Paciente> lista = pacienteRepository.findByDoctorPaciente(id);
        model.addAttribute("listaPacientes", lista);
        return "doctor/doctorPaciente";
    }
    @GetMapping("/doctorCita")
    public String mostrarCitas(@RequestParam("id") Integer id, Model model) {
        LocalDate localDate = LocalDate.now();
        List<Paciente> lista = pacienteRepository.findByDoctorPacienteAndFechaCitaAfter(id, String.valueOf(localDate));
        model.addAttribute("listaPacientes", lista);
        return "doctor/doctorCita";
    }
}
