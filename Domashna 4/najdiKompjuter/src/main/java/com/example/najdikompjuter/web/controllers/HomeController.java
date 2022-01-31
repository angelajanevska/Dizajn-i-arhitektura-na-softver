package com.example.najdikompjuter.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "pocetna";
    }

    @GetMapping("/za-nas")
    public String contact(Model model){
        model.addAttribute("content","contact");
        model.addAttribute("activeContact",true);
        return "master-template";
    }
}