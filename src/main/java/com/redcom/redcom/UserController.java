package com.redcom.redcom;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redcom.redcom.dto.User;

@RestController
public class UserController {

    @PostMapping(value = "/register", consumes = "application/json")
    public String register(@RequestBody User newUser)
    {
        String message;

        if (!newUser.getPassword().equals(newUser.getRepeatedPassword()))
        {

            message = "Passwords must match!";
        }
        else
        {

            message = "Created user with username: " + newUser.getUsername() + ", password: " + newUser.getPassword() + ", and email: " + newUser.getEmail();
        }

        return message;

    }
}
