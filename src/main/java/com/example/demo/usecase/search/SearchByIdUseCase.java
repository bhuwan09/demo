package com.example.demo.usecase.search;

import com.example.demo.connectionclass.ConnectionClass;
import com.example.demo.entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchByIdUseCase {

    public ArrayList<ProductEntity> getProductById(int id) throws SQLException {
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.con;
//
//
//        String select= "select * from product where id =?";
//        PreparedStatement ps= connection.prepareStatement(select);
//        ps.setInt(1,id);
//        ResultSet resultSet = ps.executeQuery();
//
//        ArrayList<ProductEntity> data = new ArrayList<ProductEntity>();
//
//
//        while(resultSet.next()){
//            ProductEntity entity = new ProductEntity();
//
//            entity.setId(resultSet.getInt("id"));
//            entity.setName(resultSet.getString("name"));
//            data.add(entity);
//
//        }
//
//        return data;
        return null;
    }
}
