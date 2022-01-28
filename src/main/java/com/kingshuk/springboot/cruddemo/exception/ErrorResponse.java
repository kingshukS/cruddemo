package com.kingshuk.springboot.cruddemo.exception;

public class ErrorResponse {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String message;
    private int status;
    private String description;

    public ErrorResponse(String message, int status, String description) {
        this.message = message;
        this.status = status;
        this.description = description;
    }
}
