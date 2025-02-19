package com.example.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person {
    @Id
    private Long id;
    @SuppressWarnings("unused")
    private String name;

    // Getters and Setters
}
