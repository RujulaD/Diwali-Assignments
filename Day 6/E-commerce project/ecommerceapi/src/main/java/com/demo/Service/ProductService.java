package com.demo.Service;


import org.springframework.stereotype.Service;

import com.demo.Dao.ProductRepository;
import com.demo.Models.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public Product add(Product p) { return repo.save(p); }
    public List<Product> getAll() { return repo.findAll(); }
    public Optional<Product> getById(Long id) { return repo.findById(id); }
    public Product update(Long id, Product p) {
        return repo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setDescription(p.getDescription());
            existing.setPrice(p.getPrice());
            existing.setQuantity(p.getQuantity());
            existing.setCategory(p.getCategory());
            return repo.save(existing);
        }).orElseThrow();
    }
    public void delete(Long id){ repo.deleteById(id); }
    public List<Product> searchByName(String name) { return repo.findByNameContainingIgnoreCase(name); }
}