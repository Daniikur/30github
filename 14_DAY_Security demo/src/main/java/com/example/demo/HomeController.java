package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/public")
    public String publicPage() {
        return "This is a public page.";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "This is a private page for authenticated users only.";
    }
}

