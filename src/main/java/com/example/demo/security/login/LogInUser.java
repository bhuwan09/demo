package com.example.demo.security.login;

import com.example.demo.Domain.LogInDomain;
import com.example.demo.Domain.UserDomain;
import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.dao.UserDao;
import com.example.demo.security.TokenGenerate;
import jakarta.inject.Inject;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LogInUser {
    UserConverter userConverter;
    UserDao userDao;

    public LogInUser() {

    }

    @Inject
    public LogInUser(UserConverter userConverter, UserDao userDao) {
        this.userConverter = userConverter;
        this.userDao = userDao;
    }

    public String execute(LogInDomain logInDomain) throws NoSuchAlgorithmException {
        UserEntity user = userDao.findByMail(logInDomain.getEmail());
        if(LogInPasswordEncoder.comparePasswords(logInDomain.getPassword(), user.getPassword()))
        {
            Map<String, Object> claimMap = new HashMap<>();
            String generatedToken = TokenGenerate.generateToken(claimMap, logInDomain.getEmail());
            return generatedToken;
        }else
        {
            return "fail";
        }
    }
}
