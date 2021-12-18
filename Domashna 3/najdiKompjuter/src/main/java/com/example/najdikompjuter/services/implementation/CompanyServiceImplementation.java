package com.example.najdikompjuter.services.implementation;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService{

    private final CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> add(String id, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair) {
        return this.companyRepository.add(id, name, city, street, phone, website, brand, openingHours, repair);
    }

    @Override
    public Optional<Company> findByID(String id) {
        return this.companyRepository.findByID(id);
    }

}
