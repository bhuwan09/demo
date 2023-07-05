package com.example.demo.repository.dao;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.exceptionhandler.DataAccessException;
import com.example.demo.entity.ProductEntity;
import com.example.demo.utils.DeleteApiResponse;
import jakarta.json.JsonObject;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    ProductDomain save(ProductEntity entity);

    ProductDomain getById(int id);

    List<ProductDomain> getAll(int pageNumber, int pageSize);

    void update(ProductEntity entity);
    void updateDynamically(ProductEntity entity);

    void delete(int id) throws DataAccessException;

    List<ProductDomain> searchByName(String name) throws DataAccessException;

    List<ProductDomain> searchNameStartsWith(String prefix) throws DataAccessException;

    public List<ProductDomain> dynamicSearchProduct1(ProductEntity entity);
}
