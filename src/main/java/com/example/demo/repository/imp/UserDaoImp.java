package com.example.demo.repository.imp;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.Domain.UserDomain;
import com.example.demo.converter.UserConverter;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.dao.UserDao;
import com.example.demo.security.SecurePassword;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.security.core.userdetails.User;

import java.security.NoSuchAlgorithmException;

@Default
public class UserDaoImp implements UserDao
{
    private final UserConverter converter;
    SqlSession session;

    @Inject
    public UserDaoImp(UserConverter converter, SqlSessionFactory sessionFactory) {
        this.converter = converter;
        this.session = sessionFactory.openSession();
    }

    @Override
    public UserDomain save(UserEntity entity) throws NoSuchAlgorithmException {
        session.insert("UserDao.insert", entity);
        session.commit();
        session.close();
       return converter.toUserDomain(entity);

    }

    @Override
    public UserEntity findByMail(String email) {
        UserEntity entity = session.selectOne("UserDao.getByEmail", email);
//        UserDomain domain = converter.toUserDomain(entity);
        return entity;
    }

}
