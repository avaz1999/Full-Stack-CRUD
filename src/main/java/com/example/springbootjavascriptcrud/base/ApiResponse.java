package com.example.springbootjavascriptcrud.base;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T object;

    public ApiResponse(boolean success, String message, T object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
