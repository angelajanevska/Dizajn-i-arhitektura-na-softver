package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CityController {
    private final CompanyService companyService;

    public CityController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/najdi-kompjuter")
    public String catalog(Model model) throws IOException, CsvValidationException {
        model.addAttribute("companies",companyService.findAll());
        return "katalog";
    }

    @GetMapping("/shop-in-city")
    public String filterByCity(@RequestParam String city, Model model){
        model.addAttribute("companies",companyService.findAllByCity(city));
        model.addAttribute("city",city);

//        get coordinates for the selected city
        switch (city){
            case "Битола" -> {
                model.addAttribute("lat", 41.0307);
                model.addAttribute("lon", 21.3235);
            }
            case "Велес" -> {
                model.addAttribute("lat", 41.7180);
                model.addAttribute("lon", 21.7790);
            }
            case "Гостивар" -> {
                model.addAttribute("lat", 41.7170);
                model.addAttribute("lon", 20.9050);
            }
            case "Гевгелија" -> {
                model.addAttribute("lat", 41.1444);
                model.addAttribute("lon", 22.5049);
            }
            case "Скопје" -> {
                model.addAttribute("lat", 41.9980);
                model.addAttribute("lon", 21.4590);
            }
            case "Струмица" -> {
                model.addAttribute("lat", 41.4012);
                model.addAttribute("lon", 22.6400);
            }
            case "Прилеп" -> {
                model.addAttribute("lat", 41.3466);
                model.addAttribute("lon", 21.5547);
            }
            case "Охрид" -> {
                model.addAttribute("lat", 41.1206);
                model.addAttribute("lon", 20.8033);
            }
            case "all" -> {
                return "redirect:/najdi-kompjuter";
            }
        }
        return "shops-in-city";
    }
}
