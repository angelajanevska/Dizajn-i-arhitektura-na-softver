package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.model.City;
import com.example.najdikompjuter.services.implementation.CompanyService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Objects;

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

//        get coordinates for the selected city
        if(Objects.equals(city, "all"))
            return "redirect:/najdi-kompjuter";
        else {
            City searchCity = this.companyService.findCoordinatesForCity(city);
            System.out.println(searchCity.getLat()+" "+searchCity.getLon());
            model.addAttribute("lat",searchCity.getLat());
            model.addAttribute("lon",searchCity.getLat());
            model.addAttribute("city",searchCity.getName());
        }
        return "shops-in-city";
    }
}