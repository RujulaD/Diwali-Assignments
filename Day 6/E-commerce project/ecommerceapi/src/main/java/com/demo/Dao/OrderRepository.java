package com.demo.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Models.Customer;
import com.demo.Models.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);
}
