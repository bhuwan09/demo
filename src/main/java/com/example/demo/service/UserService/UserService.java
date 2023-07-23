package com.example.demo.service.UserService;

import com.example.demo.Domain.UserDomain;
import com.example.demo.entity.UserEntity;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserDomain add(UserDomain domain) throws NoSuchAlgorithmException;
    UserEntity findByEmail(String email);

}
