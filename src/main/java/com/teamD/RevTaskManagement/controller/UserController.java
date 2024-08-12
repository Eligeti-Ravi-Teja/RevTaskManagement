package com.teamD.RevTaskManagement.controller;

import com.teamD.RevTaskManagement.utilities.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    PasswordUtils passwordUtils;
<<<<<<< HEAD

    @PostMapping("/hash")
    public String hashPassword(@RequestParam String password) {
        return passwordUtils.hashPassword(password);
    }

    @PostMapping("/verify")
    public boolean verifyPassword(@RequestParam String password, @RequestParam String hashedPassword) {
        return passwordUtils.verifyPassword(password, hashedPassword);
=======
    @PostMapping
    public String hashPassword(@RequestParam String password) {
        return passwordUtils.hashPassword(password);
>>>>>>> 2cb0927ec2d874bce097871fc86fbc3a51f2e50b
    }
}
