package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Hospital;
import com.example.lab3_20200839.entity.Paciente;
import com.example.lab3_20200839.repository.DoctorRepository;
import com.example.lab3_20200839.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class PacienteController {

    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;


    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }


    @GetMapping(value = {"/listaPacientes"})
    public String listarPacientes(Model model) {
        List<Paciente> lista = pacienteRepository.findAll();
        model.addAttribute("listPaciente", lista);

        return "paciente/list";
    }
    @GetMapping(value = {"/listDoctores2"})
    public String mostrarDoctor2(@RequestParam("id") Integer id, Model model) {
        List<Doctor> lista = doctorRepository.findByDoctorHospital(id);
        model.addAttribute("listDoctores", lista);
        return "paciente/derivarPaciente";
    }

    @GetMapping("/editar")
    public String editarPaciente(Model model,@RequestParam("id") int id) {

        Optional<Paciente> optPaciente = pacienteRepository.findById(id);

        if (optPaciente.isPresent()) {
            Paciente paciente = optPaciente.get();
            model.addAttribute("paciente", paciente);
            return "paciente/editPaciente";
        } else {
            return "redirect:/listaPacientes";
        }
    }

    @PostMapping("/actualizarH")
    public String actualizarHabitacion(@RequestParam("id") Integer id,@RequestParam("habitacionPaciente") Integer numHab) {
        pacienteRepository.actualizarHabitacion(id,numHab);
        return "redirect:/listaPacientes";
    }
    @GetMapping("/derivPaciente")
    public String derivarPaciente(Model model){
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listDoctor", lista);
        return "paciente/derivarPaciente";
    }

    @PostMapping("/actualizarDoctor")
    public String actualizarDoctor(@RequestParam("id1") Integer idDoctor1,@RequestParam("id2") Integer idDoctor2) {


        pacienteRepository.actualizarPaciente(idDoctor1,idDoctor2);
        Integer hospital1 = doctorRepository.infoHospital(idDoctor1);
        Integer hospital2 = doctorRepository.infoHospital(idDoctor2);
        //List<Doctor> lista = doctorRepository.findByDoctorId(idDoctor1);
        //Doctor hospital1 = lista.get(4);
        //List<Doctor> lista2 = doctorRepository.findByDoctorId(idDoctor2);
        //Doctor hospital2 = lista.get(4);
        pacienteRepository.derivarPaciente(hospital1,hospital2,idDoctor2);

        return "redirect:/listaPacientes";
    }



}
