package com.example.demo.service.loginService;

import com.example.demo.Domain.LogInDomain;

import java.security.NoSuchAlgorithmException;

public interface LogInService {
    public String logIn(LogInDomain logInDomain) throws NoSuchAlgorithmException;

}
