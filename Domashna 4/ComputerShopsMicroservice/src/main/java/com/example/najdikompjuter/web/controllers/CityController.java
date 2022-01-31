package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    final CompanyService companyService;

    public CityController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/najdi-kompjuter")
    public List<Company> catalog(Model model){
        return this.companyService.findAll();
    }

    @GetMapping("/shop-in-city")
    public List<Company> filterByCity(@RequestParam String city, Model model){
        return this.companyService.findAllByCity(city);
    }
}