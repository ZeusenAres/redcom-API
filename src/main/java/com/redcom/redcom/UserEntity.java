package com.redcom.redcom;

public class UserEntity {

    private final int id;

    private final String username;

    private final String password;

    private final int coins;

    public UserEntity(Integer id, String username, String password, Integer coins)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coins = coins;
    }

    public int getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getCoins()
    {
        return coins;
    }
}