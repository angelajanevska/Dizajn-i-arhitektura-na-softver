package com.example.najdikompjuter.services.implementation;

import com.example.najdikompjuter.company.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAll();
    Optional<Company> findByID(String id);
    Optional<Company> add(String id, String lat, String lon, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair);
    List<Company> findAllByCity(String city);
}
