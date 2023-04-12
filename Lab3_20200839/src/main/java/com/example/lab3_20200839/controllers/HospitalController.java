package com.example.lab3_20200839.controllers;

import com.example.lab3_20200839.entity.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HospitalController {
    @GetMapping(value = {"/listaHospitales", ""})
    public String listarTransportistas(Model model) {

        List<Hospital> lista = hospitalRepository.finAll();
        model.addAttribute("doctorList", lista);

        return "hospital/list";
    }
}
