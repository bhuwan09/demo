package com.example.demo.service.loginService;

import com.example.demo.Domain.LogInDomain;
import com.example.demo.security.login.LogInUser;
import jakarta.inject.Inject;

import java.security.NoSuchAlgorithmException;

public class LogInServiceImp implements LogInService{

    LogInUser logInUser;

    @Inject
    public LogInServiceImp(LogInUser logInUser) {
        this.logInUser = logInUser;
    }

    @Override
    public String logIn(LogInDomain logInDomain) throws NoSuchAlgorithmException {
        String execute = logInUser.execute(logInDomain);
        return execute;
    }
}
