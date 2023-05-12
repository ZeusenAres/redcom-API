package com.redcom.redcom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redcom.redcom.dto.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    public List<Products> findById(int username);

    //List<Users> findById(Short id);
}
