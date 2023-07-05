package com.example.demo.service;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.converter.ProductConverter;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptionhandler.DataAccessException;
import com.example.demo.repository.dao.ProductDao;
import com.example.demo.utils.DeleteApiResponse;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import org.mybatis.cdi.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Default
public class ProductServiceImp implements ProductService {

    private final ProductDao productDao;
    private final ProductConverter productConverter;

    @Inject
    public ProductServiceImp(ProductDao productDao,
                             ProductConverter productConverter) {
        this.productDao = productDao;
        this.productConverter = productConverter;
    }

    @Override
    public ProductDomain add(ProductDomain domain) {
        ProductDomain product ;
        product = productDao.save(productConverter.toEntity(domain));
        return product;
    }


    @Override
    public ProductDomain getById(int id) {
        ProductDomain domain = productDao.getById(id);
        return domain;
    }

    @Override
    public ProductDomain update(ProductDomain domain) {

        productDao.update(productConverter.toEntity(domain));
        return domain;
    }

    @Override
    public List<ProductDomain> getAll(int pageNumber, int pageSize) {
        List<ProductDomain> productDomainList = productDao.getAll(pageNumber, pageSize);
        return productDomainList;
    }

    @Override
    public void delete(int id) throws DataAccessException {

            productDao.delete(id);
    }

    @Override
    public List<ProductDomain> getByName(String name) throws DataAccessException {
        return productDao.searchByName(name);
    }

    @Override
    public List<ProductDomain> getNameStartsWith(String prefix) throws DataAccessException {
        return productDao.searchNameStartsWith(prefix);
    }


    public List<ProductDomain> dynamicSearchProduct1(ProductEntity productEntity){
        List<ProductDomain> productDomainList= productDao.dynamicSearchProduct1(productEntity);
        return  productDomainList;
    }

    @Override
    public ProductDomain updateDynamically(ProductDomain domain) {
        productDao.updateDynamically(productConverter.toEntity(domain));
        return domain;
    }
}
