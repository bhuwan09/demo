package com.example.demo.usecase.update;

import com.example.demo.connectionclass.ConnectionClass;
import com.example.demo.entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUseCase {
    public ProductEntity updateProduct(ProductEntity entity){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.con;

        String update = "update product set name =? where id =?";

        try{
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());


            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return entity;
    }
}
