package com.example.myapp;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User saveUser(User user) {
        user.setId("1");
        return user;
    }
}

