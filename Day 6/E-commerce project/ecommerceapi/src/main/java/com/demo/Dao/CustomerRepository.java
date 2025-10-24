package com.demo.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
