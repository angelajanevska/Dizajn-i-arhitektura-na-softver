package com.example.najdikompjuter.services.implementation;

import com.example.najdikompjuter.company.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    public List<Company> findAll();
    public Optional<Company> findByID(String id);
    public Optional<Company> add(String id, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair);
}
