package com.example.najdikompjuter.repository.NameSort;

import com.example.najdikompjuter.model.Company;

import java.util.Comparator;

public class NameSort implements Comparator<Company> {
    @Override
    public int compare(Company company1, Company company2) {
        return company1.getName().compareToIgnoreCase(company2.getName());
    }
}
