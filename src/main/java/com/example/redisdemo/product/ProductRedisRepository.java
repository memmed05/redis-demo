package com.example.redisdemo.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRedisRepository extends CrudRepository<ProductRedis, UUID> {
}
