package com.example.demo.converter;

import com.example.demo.Domain.UserDomain;
import com.example.demo.entity.UserEntity;
import com.example.demo.security.SecurePassword;
import org.springframework.security.core.userdetails.User;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UserConverter {
    public UserDomain toUserDomain(UserEntity userEntity)
    {
        UserDomain domain = new UserDomain();
        domain.setUid(userEntity.getUid());
        domain.setUsername(userEntity.getUsername());
        domain.setEmail(userEntity.getEmail());
        domain.setPassword(userEntity.getPassword());
        return domain;
    }

    public UserEntity toUserEntity(UserDomain domain) throws NoSuchAlgorithmException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUid(UUID.randomUUID().toString());
        userEntity.setPassword(SecurePassword.encryptPassword(domain.getPassword()));

        userEntity.setUsername(domain.getUsername());
        userEntity.setEmail(domain.getEmail());

        return  userEntity;
    }
}
