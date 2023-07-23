package com.example.demo.security.login;

import com.example.demo.Domain.LogInDomain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class LogInPasswordEncoder {
    private final LogInDomain logInDomain;

    public LogInPasswordEncoder(LogInDomain logInDomain) {
        this.logInDomain = logInDomain;
    }

    //method to hash a password using SHA-256 algorithm
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] encryptedPassword = md.digest();

        return Base64.getEncoder().encodeToString(encryptedPassword);
    }

    public static boolean comparePasswords(String password, String storedPassword) throws NoSuchAlgorithmException {
        String hashedUserPassword = hashPassword(password);
        return Arrays.equals(hashedUserPassword.getBytes(), storedPassword.getBytes());
    }


}
