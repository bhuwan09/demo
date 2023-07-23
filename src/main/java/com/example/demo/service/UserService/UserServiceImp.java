package com.example.demo.service.UserService;

import com.example.demo.Domain.UserDomain;
import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.dao.UserDao;
import jakarta.inject.Inject;

import java.security.NoSuchAlgorithmException;

public class UserServiceImp implements UserService{
   private final UserDao userDao;
   private final UserConverter converter;

   @Inject
    public UserServiceImp(UserDao userDao, UserConverter converter) {
        this.userDao = userDao;
        this.converter = converter;
    }

    @Override
    public UserDomain add(UserDomain domain) throws NoSuchAlgorithmException {
        return  userDao.save(converter.toUserEntity(domain));

    }

    @Override
    public UserEntity findByEmail(String email) {
        UserEntity byMail = userDao.findByMail(email);
        return byMail;
    }


}
