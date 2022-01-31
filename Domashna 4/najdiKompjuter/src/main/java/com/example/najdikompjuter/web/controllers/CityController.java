package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.model.City;
import com.example.najdikompjuter.model.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class CityController {
    private final CompanyService companyService;

    public CityController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/najdi-kompjuter")
    public String catalog(Model model){
        model.addAttribute("companies",companyService.findAll());
        model.addAttribute("activeKatalog",true);
        model.addAttribute("content","katalog");
        return "master-template";
    }

    @GetMapping("/shop-in-city")
    public String filterByCity(@RequestParam String city, Model model){
        model.addAttribute("companies",companyService.findAllByCity(city));

        if(Objects.equals(city, "all"))
            return "redirect:/najdi-kompjuter";
        else {
            // get coordinates for the selected city
            City searchCity = this.companyService.findCoordinatesForCity(city);
            model.addAttribute("lat",searchCity.getLat());
            model.addAttribute("lon",searchCity.getLat());
            model.addAttribute("city",searchCity.getName());
        }

        model.addAttribute("content","shops-in-city");
        model.addAttribute("activeKatalog",true);
        return "master-template";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model){
        if(this.companyService.findByID(id).isPresent()){
            Company company = this.companyService.findByID(id).get();
            model.addAttribute("company", company);
            model.addAttribute("content","details");
            model.addAttribute("activeKatalog",true);
            return "master-template";
        }
        return "redirect:/company?error=CompanyNotFound";
    }
}