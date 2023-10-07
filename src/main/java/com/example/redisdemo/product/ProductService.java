package com.example.redisdemo.product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductRedisRepository redisRepository;

    public ProductService(ProductRepository repository, ProductRedisRepository redisRepository) {
        this.repository = repository;
        this.redisRepository = redisRepository;
    }


    public Product save(ProductDto product) {
        return repository.save(new Product(
                product.name(),
                product.category(),
                product.price(),
                product.color()
        ));
    }

    public List<ProductDto> getAll() {
        List<Product> products = repository.findAll();
        redisRepository.saveAll(products.stream()
                .map(product -> new ProductRedis(product.getId(),product.getName(),product.getCategory()))
                .toList());
        return products.stream()
                .map(product -> new ProductDto(
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getColor()
                ))
                .toList();
    }

    public ProductDto getById(UUID id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        Product p = product.get();
        redisRepository.save(new ProductRedis(
                p.getId(),
                p.getName(),
                p.getCategory()
        ));
        return new ProductDto(
                p.getName(),
                p.getCategory(),
                p.getPrice(),
                p.getColor()
        );
    }

    public ProductRedis getByIdFast(UUID id) {
        Optional<ProductRedis> product = redisRepository.findById(id);
        return product.orElse(null);
    }

    public List<ProductRedis> getAllFast() {
        List<ProductRedis> productRedis = new ArrayList<>();
        redisRepository.findAll().forEach(productRedis::add);
        return productRedis;
    }
}
