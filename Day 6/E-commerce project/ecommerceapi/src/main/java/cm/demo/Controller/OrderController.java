package cm.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.DTO.OrderRequestDTO;
import com.demo.Models.Order;
import com.demo.Models.OrderItem;
import com.demo.Models.OrderStatus;
import com.demo.Models.Product;
import com.demo.Service.OrderService;
import com.demo.Service.ProductService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderSvc;
    private final ProductService productSvc;

    public OrderController(OrderService orderSvc, ProductService productSvc) {
        this.orderSvc = orderSvc;
        this.productSvc = productSvc;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequestDTO req){
        // convert DTO items to OrderItem entities
        List<OrderItem> items = req.items.stream().map(i -> {
            Product p = productSvc.getById(i.productId).orElseThrow();
            OrderItem oi = new OrderItem();
            oi.setProduct(p);
            oi.setQuantity(i.quantity);
            return oi;
        }).collect(Collectors.toList());

        Order order = orderSvc.placeOrder(req.customerId, items);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(orderSvc.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getByCustomer(@PathVariable Long customerId){
        return orderSvc.getByCustomer(customerId);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestParam OrderStatus status){
        return ResponseEntity.ok(orderSvc.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id){
        orderSvc.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}