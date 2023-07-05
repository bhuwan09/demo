package com.example.demo.repository.imp;

import com.example.demo.Domain.ProductDomain;
import com.example.demo.converter.ProductConverter;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptionhandler.DataAccessException;
import com.example.demo.repository.dao.ProductDao;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.cdi.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Intercepts({
        @Signature(type = ProductDaoImp.class, method = "save", args = {ProductEntity.class}),
        @Signature(type = ProductDaoImp.class, method = "getById", args = {int.class}),
        @Signature(type = ProductDaoImp.class, method = "getAll", args = {}),
        @Signature(type = ProductDaoImp.class, method = "update", args = {ProductEntity.class}),
        @Signature(type = ProductDaoImp.class, method = "delete", args = {int.class})
})
public class ProductDaoImp implements ProductDao {

    private final ProductConverter converter;
    SqlSession session;


    @Inject
    public ProductDaoImp(ProductConverter converter,
                         SqlSessionFactory sqlSessionFactory) {
        this.converter = converter;
        session = sqlSessionFactory.openSession();

    }


    @Override
    public ProductDomain save(ProductEntity entity) {
        session.insert("ProductDao.insert", entity);
        session.commit();
        session.close();

        return converter.toDomain(entity);
    }


    @Override
    public ProductDomain getById(int id) {
        ProductEntity entity = session.selectOne("ProductDao.getById", id);
        ProductDomain productDomain = converter.toDomain(entity);
//        session.commit();
//        session.close();
        return productDomain;
    }

    @Override
    public List<ProductDomain> getAll(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("offset", offset);
        parameters.put("pageSize", pageSize);

//         session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<ProductEntity> getAllProducts = session.selectList("getAllProducts", parameters);
        ProductConverter converter = new ProductConverter();
        List<ProductDomain> productDomainList = new ArrayList<>();
        getAllProducts.forEach(entity -> productDomainList.add(converter.toDomain(entity)));
        session.commit();

        return productDomainList;
//        return null;
    }

    @Override
    public void update(ProductEntity entity) {
        session.update("ProductDao.update", entity);
        session.commit();

        System.out.println("product updated successfully");

    }

    @Override
    public void delete(int id) throws DataAccessException {

        ProductEntity entity = session.selectOne("ProductDao.getById", id);
        if (entity == null) {
            throw new DataAccessException("product", "id", String.valueOf(id));

        } else {
            session.delete("ProductDao.deleteById", id);
            session.commit();
        }
    }

    @Override
    public List<ProductDomain> searchByName(String name) throws DataAccessException {
        List<ProductDomain> result = session.selectList("ProductDao.searchByName", name);
//        if(result.isEmpty()){
//            throw new DataAccessException("product", "name", name);
//        }else{
//            return result;
//        }
        if (result.isEmpty()) throw new DataAccessException("product", "name", name);
        return result;


    }

    @Override
    public List<ProductDomain> searchNameStartsWith(String prefix) throws DataAccessException {
        List<ProductDomain> results = session.selectList("ProductDao.searchNameStartsWith", prefix);
//        if(results.isEmpty()){
//            throw new DataAccessException("product", "initials", prefix);
//
//        }else {
//            return results;
//        }
        if (results.isEmpty()) throw new DataAccessException("product", "initials", prefix);
        return results;

    }


    @Override
    public List<ProductDomain> dynamicSearchProduct1(ProductEntity searchCriteria) {

        List<ProductEntity> entityList = session.selectList("ProductDao.searchByDynamic", searchCriteria);
        List<ProductDomain> domainList = new ArrayList<>();
        entityList.forEach(entity -> domainList.add(converter.toDomain(entity)));
        session.commit();
        return domainList;

    }

    @Override
    public void updateDynamically(ProductEntity entity) {
        session.update("ProductDao.updateDynamically", entity);
        session.commit();

        System.out.println("product updated successfully");
    }
}
