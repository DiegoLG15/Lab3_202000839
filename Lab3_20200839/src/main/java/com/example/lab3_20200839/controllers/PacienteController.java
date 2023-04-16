package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Paciente;
import com.example.lab3_20200839.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PacienteController {

    final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping(value = {"/listaPacientes", ""})
    public String listarPacientes(Model model) {
        List<Paciente> lista = pacienteRepository.findAll();
        model.addAttribute("listPaciente", lista);

        return "paciente/list";
    }
}
