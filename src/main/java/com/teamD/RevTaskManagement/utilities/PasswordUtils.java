package com.teamD.RevTaskManagement.utilities;

<<<<<<< HEAD
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
=======
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
>>>>>>> 2cb0927ec2d874bce097871fc86fbc3a51f2e50b
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

<<<<<<< HEAD
    // Hash the password using SHA-256
    public String hashPassword(String plainPassword) {
=======
    // Hash the password using Argon2 algorithm
    public  String hashPassword(String plainPassword) {
        Argon2 argon2 = Argon2Factory.create();

>>>>>>> 2cb0927ec2d874bce097871fc86fbc3a51f2e50b
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));

            // Convert byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error occurred while hashing password", e);
        }
    }

    // Verify the password by comparing the hash of the input with the stored hash
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return hashPassword(plainPassword).equals(hashedPassword);
    }
}
