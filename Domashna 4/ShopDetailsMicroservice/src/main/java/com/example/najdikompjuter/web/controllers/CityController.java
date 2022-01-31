package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    final CompanyService companyService;

    public CityController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/details/{id}")
    public Company details(@PathVariable String id){
        return this.companyService.findByID(id).orElseThrow();
    }
}