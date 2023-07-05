package com.example.demo.exceptionhandler;

import com.example.demo.utils.ApiResponseException;
import jakarta.ejb.ApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class GlobalExceptionHandler  implements ExceptionMapper<DataAccessException> {

    @Override
    public Response toResponse(DataAccessException e) {
        String message = e.getMessage();
        ApiResponseException responseException = new ApiResponseException(false,message);

        return Response.status(Response.Status.NOT_FOUND).entity(responseException).build();
    }
}
