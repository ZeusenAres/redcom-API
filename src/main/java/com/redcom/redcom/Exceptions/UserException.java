package com.redcom.redcom.Exceptions;

public class UserException extends Throwable {

    private String message;

    public UserException(String message)
    {

        this.message = message;
    }

    public String getMessage()
    {
        return super.getMessage();
    }

    public String setMessage(String message)
    {
        return this.message = message;
    }
}
