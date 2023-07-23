package com.example.demo.repository.dao;

import com.example.demo.Domain.UserDomain;
import com.example.demo.entity.UserEntity;
import jakarta.enterprise.inject.Default;

import java.security.NoSuchAlgorithmException;


public interface UserDao {
    UserDomain save(UserEntity entity) throws NoSuchAlgorithmException;
    UserEntity findByMail(String email);

}
