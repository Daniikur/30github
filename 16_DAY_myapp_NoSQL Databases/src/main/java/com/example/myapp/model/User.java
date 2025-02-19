package com.example.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String email;

    // Getters and Setters
}

