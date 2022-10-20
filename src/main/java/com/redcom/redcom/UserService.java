package com.redcom.redcom;

import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private AtomicInteger id;
    
    public User addUser(User newUser)
    {

        newUser.setId(id.incrementAndGet());
        return newUser;
    }
}
