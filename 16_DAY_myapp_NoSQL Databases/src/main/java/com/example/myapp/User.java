package com.example.myapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class User {
    private String id;
    private String name;
    private int age;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @PostMapping("/user")
public User createUser(@RequestBody User user) {
    user.setId("1"); // Simulate saving and setting an ID
    return user;
 }

}
