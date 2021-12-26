package com.example.najdikompjuter.web.controllers;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.services.implementation.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
//@RequestMapping()
public class CityController {
    private final CompanyService companyService;

    public CityController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/shop-in-city")
    public String filterByCity(@RequestParam String city, Model model){
        if(Objects.equals(city, "all")) model.addAttribute("companies",companyService.findAll());
        else model.addAttribute("companies",companyService.findAllByCity(city));
        model.addAttribute("city",city);
        return "shops-in-city";
    }
}
