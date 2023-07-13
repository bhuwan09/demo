package com.example.demo.usecase.search;

import com.example.demo.connectionclass.ConnectionClass;
import com.example.demo.entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchAllProductUseCase {

    public ArrayList<ProductEntity> getAllProduct() throws SQLException {
//        ArrayList<ProductEntity> data = new ArrayList<ProductEntity>();
//
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.con;
//
//        String select= "select * from product";
//        PreparedStatement ps = connection.prepareStatement(select);
//        ResultSet resultSet = ps.executeQuery();
//
//        while(resultSet.next()){
//            ProductEntity entity = new ProductEntity();
//
//            entity.setId(resultSet.getInt("id"));
//            entity.setName(resultSet.getString("name"));
//
//            data.add(entity);
//
//        }
//        return data;

        return null;
    }
}
