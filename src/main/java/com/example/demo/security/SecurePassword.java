package com.example.demo.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecurePassword {
    public static String encryptPassword(String userPassword) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(userPassword.getBytes());
        byte[] encryptedPassword = md.digest();

        return Base64.getEncoder().encodeToString(encryptedPassword);
    }
}
