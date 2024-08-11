package com.teamD.RevTaskManagement.controller;

import com.teamD.RevTaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        boolean isLoginSuccessful = userService.loginUser(username, password);
        if (isLoginSuccessful) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }
}
