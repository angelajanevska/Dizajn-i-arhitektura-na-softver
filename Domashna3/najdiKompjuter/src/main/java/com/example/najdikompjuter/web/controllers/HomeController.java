package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class HomeController {
    private final CompanyService companyService;

    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String home(Model model) throws IOException, CsvValidationException {
        return "pocetna";
    }

    @GetMapping("/najdi-kompjuter")
    public String catalog(Model model) throws IOException, CsvValidationException {
        model.addAttribute("companies",companyService.findAll());
        return "katalog";
    }

    @GetMapping("/za-nas")
    public String contact(Model model) throws IOException, CsvValidationException {
        return "contact";
    }

    @GetMapping("/mapa")
    public String mapa(Model model) throws IOException, CsvValidationException {
        model.addAttribute("companies",companyService.findAll());
        return "mapa";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model){
        if(this.companyService.findByID(id).isPresent()){
            Company company = this.companyService.findByID(id).get();
            model.addAttribute("company", company);
            return "details";
        }
        return "redirect:/company?error=CompanyNotFound";
    }
}
