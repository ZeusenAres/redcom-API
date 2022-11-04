package com.redcom.redcom.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redcom.redcom.Exceptions.UserException;
import com.redcom.redcom.dto.User;

@RestController
public class UserController {

    private String username;

    private String password;

    private String repeatedPassword;

    private String email;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public Object register(@RequestBody User newUser) throws UserException
    {

        try {

            username = newUser.getUsername();
            password = newUser.getPassword();
            repeatedPassword = newUser.getRepeatedPassword();
            email = newUser.getEmail();

            if (!password.equals(repeatedPassword)) {

                throw new UserException("Passwords must match!");
            }

            return new User(username, password, repeatedPassword, email);
        } catch (UserException ue) {

            return new UserExceptionParser(ue.getMessage());
        }
    }
}
