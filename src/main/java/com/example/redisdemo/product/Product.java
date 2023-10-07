package com.example.redisdemo.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;
    private Double price;
    private String color;

    public Product(){

    }

    public Product(String name, String category, Double price, String color) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
    }

    public Product(UUID id, String name, String category, Double price, String color) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
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

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
