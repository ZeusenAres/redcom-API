package com.redcom.redcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import com.redcom.redcom.Exceptions.UserRequestException;
import com.redcom.redcom.Repositories.UserRepository;
import com.redcom.redcom.dto.Users;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class UserController {

    private Pattern pattern;

    private Matcher matcher;

    private List<Users> users;

    private Users userDto;

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

        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        if(!getUserByUsername(username).isEmpty())
        {
            throw new UserRequestException("Username already exists");
        }

        if(!getUserByEmail(email).isEmpty())
        {
            throw new UserRequestException("Emailaddress already exists");
        }


        /*KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        password = factory.generateSecret(spec).getEncoded().toString();*/

        return userRepository.save(newUser);
    }

    @PostMapping(value = "/editUser", produces = "application/json", consumes = "application/json")
    public Users editUser(@RequestBody Map<String, String> body, Users newUser) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String id = body.get("id");
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String originalEmail = body.get("originalEmail");

        if (password.isEmpty())
        {
            throw new UserRequestException("Password cannot be empty");
        }

        if(!getUserByEmail(originalEmail).isEmpty())
        {
            newUser.setId(Integer.parseInt(id));
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEmail(email);
            userDto = userRepository.save(newUser);
        }
        return userDto;
    }

    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public Users login(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String username = body.get("username");
        String password = body.get("password");
        
        if(getUserByUsername(username).isEmpty())
        {
            throw new UserRequestException("Invalid username");
        }

        if(!getUserByUsername(username).isEmpty())
        {
            users = getUserByUsername(username);
        }

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        for(Users user : users)
        {
            if(!bcrypt.matches(password, user.getPassword()))
            {
                throw new UserRequestException("Invalid password");
            }
            userDto = user;
            break;
        }

        return userDto;
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAlUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/getById")
    public Optional<Users> getUserById(@RequestParam Integer id)
    {
		return userRepository.findById(id);
	}

    @GetMapping("/getByUsername")
    public List<Users> getUserByUsername(@RequestParam String username)
    {
		return userRepository.findByUsername(username);
	}

    @GetMapping("/getByEmail")
    public List<Users> getUserByEmail(@RequestParam String email)
    {
		return userRepository.findByEmail(email);
	}
}
