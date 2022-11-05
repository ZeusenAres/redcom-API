package com.redcom.redcom.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.redcom.redcom.Exceptions.UserException;
import com.redcom.redcom.Exceptions.UserExceptionParser;
import com.redcom.redcom.dto.User;
import com.redcom.redcom.dto.UserField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {

    private String username;

    private String password;

    private String repeatedPassword;

    private String email;

    private Pattern pattern;

    private Matcher matcher;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public Object register(@RequestBody User newUser, @RequestBody UserField userMessage) throws UserException
    {

        try {

            username = newUser.getUsername();
            password = newUser.getPassword();
            repeatedPassword = newUser.getRepeatedPassword();
            email = newUser.getEmail();

            if (username.isEmpty() || username == null) {
                
                throw new UserException("Please input a username");
            }

            if (!password.equals(repeatedPassword)) {

                throw new UserException("Passwords must match!");
            }

            if (password == null) {
                
                throw new UserException("Please input a valid password");
            }

            if (!email.isEmpty() || email != null) {
                
                pattern = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);

                matcher = pattern.matcher(email);

                boolean matchFound = matcher.find();

                if (!matchFound) {
                    
                    throw new UserException("Invalid emailaddress!");
                }
            }
            else
            {

                throw new UserException("Please input a valid emailaddress!");
            }

            newUser.registerUser(username, password, repeatedPassword, email);

            return new UserField(newUser.getIsValid(), newUser);
        } catch (UserException ue) {

            return new UserExceptionParser(ue.getMessage());
        }
    }
}
