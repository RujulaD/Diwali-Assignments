package com.demo.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryIgnoreCase(String category);
}
