package com.demo.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Dao.CustomerRepository;
import com.demo.Models.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public Customer register(Customer c) {
        c.setPassword(passwordEncoder.encode(c.getPassword()));
        return repo.save(c);
    }

    public List<Customer> getAll() { return repo.findAll(); }

    public Optional<Customer> getById(Long id) { return repo.findById(id); }

    public Customer update(Long id, Customer updated) {
        return repo.findById(id).map(c -> {
            c.setFirstName(updated.getFirstName());
            c.setLastName(updated.getLastName());
            c.setAddress(updated.getAddress());
            c.setPhoneNumber(updated.getPhoneNumber());
            // do not change email/password unless handled specially
            return repo.save(c);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void delete(Long id) { repo.deleteById(id); }
}
