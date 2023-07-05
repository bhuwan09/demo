package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.jetbrains.annotations.NotNull;

import java.beans.Statement;
import java.util.Properties;
import java.util.concurrent.Executor;

//import static org.apache.ibatis.session.AutoMappingUnknownColumnBehavior.LogHolder.log;


//@Intercepts({@Signature(
//        type = Executor.class,
//        method = "update",
//        args = {MappedStatement.class, Object.class}),
//        @Signature(
//                type = Executor.class,
//                method = "query",
//                args = {MappedStatement.class, Object.class})
//})
@Slf4j
public class CustomInterceptor {
//    private Properties properties = new Properties();
//
//    @Override
//    public Object intercept(@NotNull Invocation invocation) throws Throwable {
//
////        log.debug("getTarget={}", invocation.getTarget());
////        log.debug("getTarget={}", invocation.getMethod());
////        log.debug("getArgs={}", invocation.getArgs());
////
////        Object[] args = invocation.getArgs();
////        Statement stmt = (Statement) args[0];
//        Object returnObject = invocation.proceed();
//        log.debug("returnObject={}", returnObject);
//        System.out.println("hello");
//
//        return returnObject;
//    }
//
//    @Override
//    public Object plugin(Object target) {
////        return Interceptor.super.plugin(target);
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }
}
