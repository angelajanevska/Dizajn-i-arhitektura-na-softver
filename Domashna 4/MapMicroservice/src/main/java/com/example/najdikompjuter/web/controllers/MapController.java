package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MapController {

    @Autowired
    final CompanyService companyService;

    public MapController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/mapa")
    public List<Company> mapa(Model model) throws IOException, CsvValidationException {
        return this.companyService.findAll();
    }
}
