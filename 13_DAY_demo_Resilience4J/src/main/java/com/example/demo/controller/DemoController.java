package com.example.demo.controller;

import com.example.demo.service.UnstableService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final UnstableService unstableService;

    public DemoController(UnstableService unstableService) {
        this.unstableService = unstableService;
    }

    @GetMapping("/unstable")
    @CircuitBreaker(name = "unstableService", fallbackMethod = "fallbackMethod")
    public String callUnstableService() {
        return unstableService.unstableMethod();
    }

    public String fallbackMethod(Exception e) {
        return "Fallback: Service is temporarily unavailable.";
    }
}
