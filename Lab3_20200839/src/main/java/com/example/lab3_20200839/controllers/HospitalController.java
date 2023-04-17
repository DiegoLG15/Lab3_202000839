package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Hospital;
import com.example.lab3_20200839.entity.Paciente;
import com.example.lab3_20200839.repository.DoctorRepository;
import com.example.lab3_20200839.repository.HospitalRepository;
import com.example.lab3_20200839.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    public HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping(value = {"/listaHospitales","/"})
    public String listarHospitales(Model model) {

        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("listHospital", lista);

        return "hospital/list";
    }
    @GetMapping("/hospitalDoctor")
    public String mostrarDoctores(@RequestParam("id") Integer id, Model model) {

        List<Doctor> lista = doctorRepository.findByDoctorHospital(id);
        model.addAttribute("listDoctores", lista);
        return "hospital/mostrarDoctores";
    }
    @GetMapping("/hospitalPacientes")
    public String mostrarPacientes(@RequestParam("id") Integer id, Model model) {

        List<Paciente> lista = pacienteRepository.findByHospitalPaciente(id);
        model.addAttribute("listaPacientes", lista);
        return "doctor/doctorPaciente";
    }
}