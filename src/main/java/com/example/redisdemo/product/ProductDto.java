package com.example.redisdemo.product;

public record ProductDto(
        String name,
        String category,
        Double price,
        String color
) {
}
