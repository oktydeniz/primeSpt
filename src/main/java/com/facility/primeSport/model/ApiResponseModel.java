package com.facility.primeSport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ApiResponseModel<T>{
    private boolean success;
    private String message;
    private T data;

    public ApiResponseModel(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponseModel() {

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ApiResponseModel<T> create(T value, String msg, boolean success) {
        ApiResponseModel<T> response = new ApiResponseModel<>();
        response.setData(value);
        response.setMessage(msg);
        response.setSuccess(success);
        return response;
    }

    public static <T> ApiResponseModel<T> create(T value) {
        ApiResponseModel<T> response = new ApiResponseModel<>();
        response.setData(value);
        response.setMessage("");
        response.setSuccess(true);
        return response;
    }

    public static <T> ApiResponseModel<T> create(String msg, boolean success) {
        ApiResponseModel<T> response = new ApiResponseModel<>();
        response.setMessage(msg);
        response.setSuccess(success);
        return response;
    }
}
