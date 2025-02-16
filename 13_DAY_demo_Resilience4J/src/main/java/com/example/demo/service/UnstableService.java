package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UnstableService {

    private final Random random = new Random();

    public String unstableMethod() {
        if (random.nextBoolean()) { 
            throw new RuntimeException("Service is down!"); // Simulating failure
        }
        return "Success from Unstable Service!";
    }
}
