package com.redcom.redcom.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String username;

    private String password;

    private String email;
    
    public Users()
    {
        
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
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

    public String setEmail(String email)
    {
        return this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
}
