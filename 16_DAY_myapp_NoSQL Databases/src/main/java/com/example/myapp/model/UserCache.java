package com.example.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("User")
public class UserCache {
    @Id
    private String id;
    @SuppressWarnings("unused")
    private String name;

    // Getters and Setters
}
