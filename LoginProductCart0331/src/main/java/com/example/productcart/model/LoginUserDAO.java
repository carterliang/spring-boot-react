package com.example.productcart.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserDAO extends JpaRepository<LoginUser,Integer>{
     LoginUser findByUserNameAndPassword(String name,String password);
} 
