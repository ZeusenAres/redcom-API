package com.redcom.redcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.redcom.redcom.Exceptions.UserException;
import com.redcom.redcom.Exceptions.UserExceptionParser;
import com.redcom.redcom.Repositories.UserRepository;
import com.redcom.redcom.dto.Users;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    private Pattern pattern;

    private Matcher matcher;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/register")
    public Users register(@RequestBody Map<String, String> body, Users newUser)
    {
        
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");

        return userRepository.save(new Users(username, password, email));
    }

    @GetMapping("/allUsers")
    public List<Users> index()
    {
        return userRepository.findAll();
    }
    
}
