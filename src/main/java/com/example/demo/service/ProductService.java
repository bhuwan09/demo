package com.example.demo.service;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptionhandler.DataAccessException;
import com.example.demo.utils.DeleteApiResponse;
import jakarta.json.JsonObject;

import java.util.List;
import java.util.Map;


public interface ProductService {
    ProductDomain add(ProductDomain domain);


    ProductDomain getById(String id);

    ProductDomain update(ProductDomain domain);
    ProductDomain updateDynamically(ProductDomain domain);

    List<ProductDomain> getAll(int pageNumber, int pageSize);

    void delete(String  id) throws DataAccessException;

    List<ProductDomain> getByName(String name) throws DataAccessException;

    List<ProductDomain> getNameStartsWith(String prefix) throws DataAccessException;

    public List<ProductDomain> dynamicSearchProduct1(ProductEntity productEntity);


}
