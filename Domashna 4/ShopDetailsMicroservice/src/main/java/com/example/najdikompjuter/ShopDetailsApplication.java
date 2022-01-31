package com.example.najdikompjuter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopDetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopDetailsApplication.class, args);
    }

}
