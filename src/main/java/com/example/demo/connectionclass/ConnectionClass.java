package com.example.demo.connectionclass;

import org.apache.ibatis.jdbc.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public Connection con;

    public ConnectionClass(){
//        try{
//            String url =String.format("jdbc:mysql://localhost:3306/wildfly_crud");
//            String username= "root";
//            String password = "root";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, username, password);
//        }catch (Exception ex)
//        {
//            System.out.println(ex+"Error data connection");
//        }
    }


}
