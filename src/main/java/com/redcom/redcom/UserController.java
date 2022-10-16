package com.redcom.redcom;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private AtomicInteger id = new AtomicInteger();

    private String username;

    private String password;

    private String email;

    @PostMapping(path = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser()
    {
        return new User(id.incrementAndGet(), username, password, email);
    }
}
