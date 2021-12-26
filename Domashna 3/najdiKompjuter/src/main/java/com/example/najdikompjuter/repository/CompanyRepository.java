package com.example.najdikompjuter.repository;

import com.example.najdikompjuter.company.Company;
import com.example.najdikompjuter.repository.NameSort.NameSort;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    public static List<Company> companyList = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
        String[] data;
        String[] elements;
        reader.readNext();
        while((data = reader.readNext()) != null){
            elements = Arrays.toString(data).split(",");
            Company company = new Company(elements[0].replace('[',' '),elements[1], elements[2], elements[3],elements[4],elements[5],elements[6],elements[7],elements[8],elements[9],elements[10].replace(']',' '));
            companyList.add(company);
        }
    }

    public List<Company> findAll(){
        companyList.sort(new NameSort());
        return companyList;
    }

    public Optional<Company> add(String id, String lat, String lon, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair){
        Company company = new Company(id, lat, lon, name, city, street, phone, website, brand, openingHours, repair);
        companyList.add(company);
        return Optional.of(company);
    }

    public Optional<Company> findByID(String id){
        return companyList.stream().filter(i->i.getId().equals(id)).findFirst();
    }

    public List<Company> findAllByCity(String city){
        return companyList.stream().filter(c->c.getCity().contains(city)).collect(Collectors.toList());
    }
}