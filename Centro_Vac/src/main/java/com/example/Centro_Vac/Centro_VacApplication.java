package com.example.Centro_Vac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient

public class Centro_VacApplication {
    public static void main(String[] args) {
        SpringApplication.run(Centro_VacApplication.class, args);
    }
}
