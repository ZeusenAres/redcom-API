package com.redcom.redcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redcom.redcom.dto.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findByUsername(String username);

    List<Users> findByEmail(String email);

    //List<Users> findById(Short id);
}
