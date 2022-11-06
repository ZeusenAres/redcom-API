package com.redcom.redcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redcom.redcom.dto.Users;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    
    List<Users> findByUsernameContainingOrEmailContaining(String username, String email); 
}
