package com.redcom.redcom;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redcom.redcom.dto.User;

@RestController
public class UserController {

    private String username;

    private String password;

    private String repeatedPassword;

    private String email;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public User register(@RequestBody User newUser)
    {

        username = newUser.getUsername();
        password = newUser.getPassword();
        repeatedPassword = newUser.getRepeatedPassword();
        email = newUser.getEmail();

        return new User(username, password, repeatedPassword, email);
    }
}
