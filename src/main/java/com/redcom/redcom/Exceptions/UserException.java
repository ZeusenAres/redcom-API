package com.redcom.redcom.Exceptions;

public class UserException extends RuntimeException {

    private String message;

    public UserException(String message)
    {

        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String setMessage(String message)
    {
        return this.message = message;
    }
}
