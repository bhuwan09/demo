package com.example.demo.exceptionhandler;

public class ProductException extends RuntimeException {
    public ProductException(String message){
        super(message);
    }
}
