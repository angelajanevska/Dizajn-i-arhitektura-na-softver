package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {
    private final CompanyService companyService;

    public MapController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/mapa")
    public String mapa(Model model){
        model.addAttribute("companies",companyService.findAll());
        return "mapa";
    }
}
