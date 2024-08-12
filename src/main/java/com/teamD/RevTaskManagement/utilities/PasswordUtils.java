package com.teamD.RevTaskManagement.utilities;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    // Hash the password using Argon2 algorithm
    public  String hashPassword(String plainPassword) {
        Argon2 argon2 = Argon2Factory.create();

        try {
            // Number of iterations, memory cost, and parallelism (you can adjust these based on your needs)
            int iterations = 2; // Less number of iterations for fast hashing
            int memory = 65536; // Memory cost (64MB)
            int parallelism = 1; // Number of threads and cores to use

            // Hashing the password
            return argon2.hash(iterations, memory, parallelism, plainPassword.toCharArray());
        } finally {
            argon2.wipeArray(plainPassword.toCharArray()); // Ensure the plain password is wiped from memory
        }
    }
}
