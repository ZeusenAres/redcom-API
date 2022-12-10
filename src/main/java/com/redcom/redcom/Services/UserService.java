package com.redcom.redcom.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.redcom.redcom.Repositories.UserRepository;
import com.redcom.redcom.dto.Users;

public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){

        List<Users> users = new ArrayList<Users>();

        userRepository.findAll().forEach(user -> users.add(user));

        return users;
    }
}
