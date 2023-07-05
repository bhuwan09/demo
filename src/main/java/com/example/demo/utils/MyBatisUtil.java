package com.example.demo.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.cdi.SessionFactoryProvider;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class MyBatisUtil {

    @ApplicationScoped
    @Produces
    @SessionFactoryProvider
    public SqlSessionFactory produce() {

        try {
            String resource = "META-INF/mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            return new SqlSessionFactoryBuilder().build(reader, this.configDbProperties());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Properties configDbProperties() {
        Properties properties = new Properties();
        properties.setProperty("db_driver", System.getenv("db_driver"));
        properties.setProperty("db_url", System.getenv("db_url"));
        properties.setProperty("db_user", System.getenv("db_user"));
        properties.setProperty("db_password", System.getenv("db_password"));
        return properties;
    }


}
