package com.example.demo.usecase.delete;

import com.example.demo.connectionclass.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUseCase {

    public int deleteProduct(int id)
    {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection =connectionClass.con ;
        String delete = "delete from product where id=?";

        try{
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1,id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
