package com.redcom.redcom.dto;

public class User {

    private String username;

    private String password;

    private String repeatedPassword;

    private String email;

    public User(String username, String password, String repeatedPassword, String email) {

        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.email = email;
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
}
