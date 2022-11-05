package com.redcom.redcom.dto;

public class User {

    private String username;

    private String password;

    private String repeatedPassword;

    private String email;

    private boolean isValid;

    public void registerUser(String username, String password, String repeatedPassword, String email) {

        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.email = email;

        if (this.username != null || !this.username.isEmpty()) {
            
            if (this.password != null || !this.password.isEmpty()) {
            
                if (this.repeatedPassword != null || !this.repeatedPassword.isEmpty()) {
            
                    if (this.email != null || !this.email.isEmpty()) {
            
                        isValid = setIsValid(true);
                    }
                }
            }
        }
    }

    public String setUsername(String username)
    {
        return this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public String setPassword(String password)
    {
        return this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String setRepeatedPassword(String repeatedPassword)
    {
        return this.repeatedPassword = repeatedPassword;
    }

    public String getRepeatedPassword()
    {
        return repeatedPassword;
    }

    public String setEmail(String email)
    {
        return this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public boolean setIsValid(Boolean isValid)
    {
        return this.isValid = isValid;
    }

    public boolean getIsValid()
    {
        return isValid;
    }
}
