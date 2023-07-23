package com.example.demo.controller.ProductController;


import com.example.demo.Domain.ProductDomain;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.SearchCriteria;
import com.example.demo.exceptionhandler.DataAccessException;
import com.example.demo.security.TokenGenerate;
import com.example.demo.security.TokenVerification;
import com.example.demo.service.ProductService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.DeleteApiResponse;
import com.example.demo.validation.Validation;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.SQLException;
import java.util.List;

@Path("/product1")
@Default
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Controller {


    ProductService productService;
    TokenVerification tokenVerification;

    TokenGenerate tokenGenerate;

    public Controller() {

    }

    @Inject
    public Controller(ProductService productService, TokenVerification tokenVerification, TokenGenerate tokenGenerate) {
        this.productService = productService;
        this.tokenVerification = tokenVerification;
        this.tokenGenerate = tokenGenerate;
    }


    @POST
    @Path("/add")
    public ApiResponse<ProductDomain> addProduct(ProductDomain domain) {
    if(Validation.validateInput(domain)) {
        ProductDomain add = productService.add(domain);
        return new ApiResponse<>("00", "product added successfully", add);
//        return null;
    }else{
//        ProductDomain details = null;
        return new ApiResponse<>("01","Please enter valid input", null);
    }
    }


    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") String id) {
        ProductDomain domain = productService.getById(id);
        return Response.ok().entity(domain).build();

    }

    @Path("/get/all/")
    @GET
//   @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<List<ProductDomain>> getAll(@HeaderParam("Authorization") String token, @QueryParam("pageNumber") @DefaultValue("1") int pageNumber,
                                      @QueryParam("pageSize") @DefaultValue("10") int pageSize
                                   ) throws SQLException
    {
        if(!tokenVerification.verifyToken(token))
            return new ApiResponse<List<ProductDomain>>("403","Access Denied Token Invalid", null);
        List<ProductDomain> productDomainList = productService.getAll(pageNumber, pageSize);

        return new ApiResponse<>("00", "Result Showing for all Products",productDomainList);
    }



    @Path("/update")
    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse updateProduct(ProductDomain domain) {
        ProductDomain update = productService.update(domain);

//        return new ApiResponse("00", "product updated successfully", update);
        return null;
    }

    @Path("/updateDynamic")
    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse updateProductDynamically(ProductDomain domain) {
        ProductDomain update = productService.updateDynamically(domain);

//        return new ApiResponse("00", "product updated successfully", update);
        return null;
    }


    @Path("/delete")
    @DELETE
    public DeleteApiResponse deleteProduct(@QueryParam("id") String id) throws DataAccessException {
        productService.delete(id);
        return new DeleteApiResponse("00", "deleted successfully");

    }

    @GET
    @Path("/search/{name}")
    public ApiResponse searchByName(@PathParam("name") String name) throws DataAccessException {
        List<ProductDomain> byName = productService.getByName(name);
        return new ApiResponse("00", "Name found", byName);
    }

    @GET
    @Path("/search/startswith/{prefix}")
    public ApiResponse searchNameStartsWith(@PathParam("prefix") String prefix) throws DataAccessException {
        List<ProductDomain> nameStartsWith = productService.getNameStartsWith(prefix);
        return new ApiResponse("00", "Found Name starts with ", nameStartsWith);
    }

    @Path("/test")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from Bhuwan";
    }


    @POST
    @Path("/searchDynamic")
    public List<ProductDomain> searchProducts(SearchCriteria searchCriteria) throws Exception {
        String id = searchCriteria.getId();
        String name = searchCriteria.getName();
        String email = searchCriteria.getEmail();
        String phoneNumber = searchCriteria.getPhoneNumber();

        ProductEntity productEntity = new ProductEntity(id, name, email, phoneNumber);
        return productService.dynamicSearchProduct1(productEntity);
    }

//    @GET
//    @Path("/searchDynamic")
//    public List<ProductDomain> getProducts(@QueryParam("id") int id,
//                                           @QueryParam("name") String name,
//                                           @QueryParam("email") String email,
//                                           @QueryParam("phoneNumber") long phoneNumber) throws Exception {
//        ProductEntity searchCriteria = new ProductEntity(id, name, email, phoneNumber);
//        searchCriteria.setId(id);
//        searchCriteria.setName(name);
//        searchCriteria.setEmail(email);
//        searchCriteria.setPhoneNumber(phoneNumber);
//
//        List<ProductDomain> products = productService.dynamicSearchProduct1(searchCriteria);
//
//        return products;
//    }


}


