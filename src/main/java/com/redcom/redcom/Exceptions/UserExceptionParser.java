package com.redcom.redcom.Exceptions;

public class UserExceptionParser {

    private String message;

    public UserExceptionParser(String message)
    {

        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
