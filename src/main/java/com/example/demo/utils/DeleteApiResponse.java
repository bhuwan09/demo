package com.example.demo.utils;

public class DeleteApiResponse<T> {
    private String code;
    private String message;

    private T data;
    public DeleteApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public DeleteApiResponse( T data){

        this.data = data;
    }


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
}
