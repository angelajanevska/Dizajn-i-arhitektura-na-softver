package com.example.najdikompjuter.services.implementation;

import com.example.najdikompjuter.model.City;
import com.example.najdikompjuter.model.Company;
import com.example.najdikompjuter.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService{

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;

    public CompanyServiceImplementation(CompanyRepository companyRepository, RestTemplate restTemplate) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Company> findAll() {
        Company[] companies = restTemplate.getForObject("http://localhost:9093/mapa",Company[].class);
        return Arrays.asList(companies);
    }

    @Override
    public Optional<Company> add(String id, String lat, String lon, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair) {
        return this.companyRepository.add(id, lat, lon, name, city, street, phone, website, brand, openingHours, repair);
    }

    @Override
    public Optional<Company> findByID(String id) {
        Company company = restTemplate.getForObject("http://localhost:9094/details/{"+id+"}",Company.class,id);
        return Optional.of((company));
    }

    @Override
    public List<Company> findAllByCity(String city){
        Company[] companies = restTemplate.getForObject("http://localhost:9093/shop-in-city?city={"+city+"}",Company[].class,city);
        return Arrays.asList(companies);
    }

    @Override
    public City findCoordinatesForCity(String city) {
        return this.companyRepository.findCoordinatesForCity(city);
    }
}