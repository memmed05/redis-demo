package com.example.redisdemo.product;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("product")
public class ProductRedis {

    @Id
    private UUID id;
    private String name;
    private String category;

    public ProductRedis() {

    }

    public ProductRedis(UUID id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
