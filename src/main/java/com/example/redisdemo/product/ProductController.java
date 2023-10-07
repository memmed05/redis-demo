package com.example.redisdemo.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/fast/{id}")
    public ResponseEntity<ProductRedis> getByIdFast(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getByIdFast(id));
    }

    @GetMapping("fast/all")
    public ResponseEntity<List<ProductRedis>> getAllFast(){
        return ResponseEntity.ok(service.getAllFast());
    }
}
