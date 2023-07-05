package com.example.demo.controller.ProductController;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class TestController {

    @GET
    public String test(){
        return"Hello";
    }
}
