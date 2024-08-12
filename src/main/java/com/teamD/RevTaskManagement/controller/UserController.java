package com.teamD.RevTaskManagement.controller;

import com.teamD.RevTaskManagement.utilities.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    PasswordUtils passwordUtils;
    @PostMapping
    public String hashPassword(@RequestParam String password) {
        return passwordUtils.hashPassword(password);
    }
}
