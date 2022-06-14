package com.polytech.palmipedewebapp.exception;

public class UserNotFoundException extends Exception{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotFoundException(String message) {

    }

}
