package com.example.demo.exceptionhandler;

public class DataAccessException extends Exception {


//    public DataAccessException(String message){
//        super(message);
//    }
//
//    public DataAccessException(String message, Throwable cause){
//        super(message, cause);
//    }


    String resourceName;
    String fieldName;
    String fieldValue;

    public DataAccessException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
