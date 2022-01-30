package com.example.najdikompjuter.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
