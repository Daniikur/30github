package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "User management operations")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Fetch all users from the database")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Save a new user in the database")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}

