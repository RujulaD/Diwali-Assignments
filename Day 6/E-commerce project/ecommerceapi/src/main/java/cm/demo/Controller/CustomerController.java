package cm.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.Models.Customer;
import com.demo.Service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService svc;
    public CustomerController(CustomerService svc) { this.svc = svc; }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer c){
        return ResponseEntity.ok(svc.register(c));
    }

    @GetMapping
    public List<Customer> getAll(){ return svc.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return svc.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer c){
        return ResponseEntity.ok(svc.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}