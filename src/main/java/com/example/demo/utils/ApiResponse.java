package com.example.demo.utils;

import java.util.Map;

public class ApiResponse<T> {

    public String code;

    public String message;


    public T data;




    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public  ApiResponse(){};
    public ApiResponse(String code, String message)
    {
        this.code= code;
        this.message=message;
    }

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
