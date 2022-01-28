package com.kingshuk.springboot.cruddemo.exception;

public class EmployeeNotFoundException extends RuntimeException{

    private String message;
    private int status;
    private String description;

    public EmployeeNotFoundException(int id){
        message = "Record not exist";
        status = 404;
        description = "Employee Not Found for ID="+id;
    }

    @Override
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
}
