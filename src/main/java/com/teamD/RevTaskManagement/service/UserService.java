package com.teamD.RevTaskManagement.service;

import com.teamD.RevTaskManagement.utilities.PasswordUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // In-memory map to store users (username -> hashed password)
    private Map<String, String> userDatabase = new HashMap<>();

    public void registerUser(String username, String plainPassword) {
        // Hash the password using Argon2 and store it
        String hashedPassword = PasswordUtils.hashPassword(plainPassword);
        userDatabase.put(username, hashedPassword);
    }

    public boolean loginUser(String username, String plainPassword) {
        // Retrieve the hashed password from the database
        String storedHashedPassword = userDatabase.get(username);

        if (storedHashedPassword == null) {
            // User does not exist
            return false;
        }

        // Hash the input password and compare it with the stored hashed password
        String hashedInputPassword = PasswordUtils.hashPassword(plainPassword);
        return storedHashedPassword.equals(hashedInputPassword);
    }
}
