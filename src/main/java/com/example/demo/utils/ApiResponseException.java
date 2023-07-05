package com.example.demo.utils;

public class ApiResponseException {


    private boolean status;
    private String message;

    public ApiResponseException() {
    }

    public ApiResponseException( Boolean status,String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
