package cm.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.Models.Product;
import com.demo.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService svc;
    public ProductController(ProductService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product p){ return ResponseEntity.ok(svc.add(p)); }

    @GetMapping
    public List<Product> getAll(){ return svc.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return svc.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
        return ResponseEntity.ok(svc.update(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String q){
        return svc.searchByName(q);
    }
}
