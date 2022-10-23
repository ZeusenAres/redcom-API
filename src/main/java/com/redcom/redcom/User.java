package com.redcom.redcom;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private String user;

<<<<<<< Updated upstream
    public int setId(int id)
    {
        return id;
    }

    public String getUsername()
=======
    public User(String user)
>>>>>>> Stashed changes
    {
        this.user = user;
    }

    public Integer setId(AtomicInteger id)
    {
        return this.setId(id);
    }

    public String getUser()
    {
        return user;
    }
}
