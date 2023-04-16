package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Doctor;
import com.example.lab3_20200839.entity.Hospital;
import com.example.lab3_20200839.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping(value = {"/listaHospitales"})
    public String listarHospitales(Model model) {

        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("listHospital", lista);

        return "hospital/list";
    }
}
