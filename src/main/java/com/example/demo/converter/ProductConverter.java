package com.example.demo.converter;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.entity.ProductEntity;

import jakarta.json.JsonObject;
import org.mybatis.cdi.Transactional;

@Transactional
public class ProductConverter {
    public ProductDomain toDomain(ProductEntity entity)
    {
        ProductDomain domain = new ProductDomain();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setEmail(entity.getEmail());
        domain.setPhoneNumber(entity.getPhoneNumber());
        return domain;
    }

    public ProductEntity toEntity(ProductDomain domain)
    {
        ProductEntity entity = new ProductEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        return entity;
    }


}
