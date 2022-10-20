package com.redcom.redcom;

<<<<<<< Updated upstream
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private AtomicInteger id;
    
    public User addUser(User newUser)
    {

        newUser.setId(id.incrementAndGet());
        return newUser;
=======
public class UserService {

    public User addUser(User newUser)
    {

>>>>>>> Stashed changes
    }
}
