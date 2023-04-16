package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class DoctorController {

    final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @GetMapping(value = {"/listaDoctores"})
    public String listarDoctores(Model model) {
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listDoctor", lista);
        return "doctor/list";
    }


}
