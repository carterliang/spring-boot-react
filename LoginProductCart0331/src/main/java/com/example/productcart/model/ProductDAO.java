package com.example.productcart.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductWithImage,Integer> {
  
}

