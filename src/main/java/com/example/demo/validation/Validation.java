package com.example.demo.validation;

import com.example.demo.Domain.ProductDomain;
import jakarta.validation.Payload;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validName(ProductDomain domain) {
        String regex = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (domain.getName() == null) {
            return false;
        }
        Matcher m = p.matcher(domain.getName());
        return m.matches();
    }

    public static boolean validPhoneNumber(ProductDomain domain) {
        String regex = "^\\+?[0-9]{8,15}$";
        Pattern p = Pattern.compile(regex);

        if (domain.getPhoneNumber() == null) {
            return false;
        }
        Matcher m = p.matcher(domain.getPhoneNumber());
        return m.matches();
    }

    public static boolean validEmail(ProductDomain domain) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern p = Pattern.compile(regex);

        if (domain.getEmail() == null) {
            return false;
        }
        Matcher m = p.matcher(domain.getEmail());
        return m.matches();

    }

    public static boolean validateInput(ProductDomain domain) {
        boolean result = false;
        if (domain.getEmail() == null || domain.getName() == null || domain.getPhoneNumber() == null) {
            return false;
        } else {
            if (validName(domain) && validPhoneNumber(domain) && validEmail(domain))
                result = true;

        }
        return result;
    }

}
