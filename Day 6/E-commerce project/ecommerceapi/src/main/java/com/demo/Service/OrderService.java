package com.demo.Service;


import org.springframework.stereotype.Service;

import com.demo.Dao.CustomerRepository;
import com.demo.Dao.OrderRepository;
import com.demo.Dao.ProductRepository;
import com.demo.Models.Customer;
import com.demo.Models.Order;
import com.demo.Models.OrderItem;
import com.demo.Models.OrderStatus;
import com.demo.Models.Product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, CustomerRepository customerRepo, ProductRepository productRepo){
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public Order placeOrder(Long customerId, List<OrderItem> items) {
        Customer customer = customerRepo.findById(customerId).orElseThrow();
        // calculate total and adjust stock
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem oi : items) {
            Product p = productRepo.findById(oi.getProduct().getId()).orElseThrow();
            if (p.getQuantity() < oi.getQuantity()) throw new RuntimeException("Insufficient stock");
            p.setQuantity(p.getQuantity() - oi.getQuantity());
            productRepo.save(p);
            oi.setPrice(p.getPrice());
            total = total.add(p.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())));
        }
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(items);
        order.setTotalAmount(total);
        order.setOrderDate(Instant.now());
        order.setStatus(OrderStatus.PENDING);
        return orderRepo.save(order);
    }

    public Order getById(Long id) { return orderRepo.findById(id).orElseThrow(); }
    public List<Order> getByCustomer(Long customerId){
        Customer c = customerRepo.findById(customerId).orElseThrow();
        return orderRepo.findByCustomer(c);
    }
    public Order updateStatus(Long orderId, OrderStatus status){
        Order o = orderRepo.findById(orderId).orElseThrow();
        o.setStatus(status);
        return orderRepo.save(o);
    }
    public void cancelOrder(Long id){ 
        Order o = orderRepo.findById(id).orElseThrow();
        o.setStatus(OrderStatus.CANCELLED);
        orderRepo.save(o);
       
    }
}