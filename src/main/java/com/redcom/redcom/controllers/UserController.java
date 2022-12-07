package com.redcom.redcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.redcom.redcom.Exceptions.UserRequestException;
import com.redcom.redcom.Repositories.UserRepository;
import com.redcom.redcom.dto.Users;
import com.redcom.redcom.Services.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
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
    private UserRepository userRepository;

    @PostMapping(value = "/register", produces = "application/json", consumes = "application/json")
    public Users register(@RequestBody Map<String, String> body, Users newUser) throws NoSuchAlgorithmException, InvalidKeySpecException
    {

        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");

        pattern = Pattern.compile("^(.+)@(.+)$");

        matcher = pattern.matcher(email);

        if (!matcher.matches()) {

            throw new UserRequestException("Invalid emailaddress");
        }

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        password = bcrypt.encode(password);

        /*KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        password = factory.generateSecret(spec).getEncoded().toString();*/

        return userRepository.save(new Users(username, password, email));
    }

    @GetMapping("/users")
    public List<Users> getAlUsers(){

        UserService userService = new UserService();

        return userService.getAllUsers();
    }

}
