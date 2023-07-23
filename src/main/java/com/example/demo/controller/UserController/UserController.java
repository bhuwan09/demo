package com.example.demo.controller.UserController;

import com.example.demo.Domain.LogInDomain;
import com.example.demo.Domain.UserDomain;
import com.example.demo.service.UserService.UserService;
import com.example.demo.service.loginService.LogInService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.security.NoSuchAlgorithmException;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

     UserService userService;
     LogInService logInService;



    public UserController(){}
    @Inject
    public UserController(UserService userService, LogInService logInService) {
        this.userService = userService;
        this.logInService = logInService;
    }

    @POST
    @Path("/signup")
    public UserDomain addUser(UserDomain domain) throws NoSuchAlgorithmException {
        UserDomain add = userService.add(domain);
        return add;
    }

    @GET
    @Path("/findByMail/{email}")
    public UserDomain findByMail(@PathParam("email") String email){
//        UserDomain byEmail = userService.findByEmail(email);
//        return byEmail;
        return null;
    }

    @POST
    @Path("/login")

    public String logIn(LogInDomain domain) throws NoSuchAlgorithmException {
        String response = logInService.logIn(domain);
        return response;
    }

}
