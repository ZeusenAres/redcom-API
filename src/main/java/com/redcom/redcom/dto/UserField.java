package com.redcom.redcom.dto;

public class UserField {
    
    private String message;

    public UserField(Boolean userCredentials, User user)
    {

        if (userCredentials == true) {
            
            this.setMessage("Succesfully registered as " + user.getUsername());
        }

        this.message = this.getMessage();
    }

    public String setMessage(String message)
    {
        return this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
