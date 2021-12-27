package com.example.najdikompjuter.company;

import lombok.Data;

@Data
public class Company {
    String id;
    String lat;
    String lon;
    String name;
    String city;
    String street;
    String phone;
    String website;
    String brand;
    String openingHours;
    String repair;

    public Company(String id, String lat, String lon, String name, String city, String street, String phone, String website, String brand, String openingHours, String repair) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.city = city;
        this.street = street;
        this.phone = phone;
        this.website = website;
        this.brand = brand;
        this.openingHours = openingHours;
        this.repair = repair;
    }
}
