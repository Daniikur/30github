package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Cacheable(value = "numbers", key = "#input")
    public int getNumber(int input) {
        try {
            Thread.sleep(3000);  // Simulating slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * 10;
    }
}
