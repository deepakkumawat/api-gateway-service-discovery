package com.nagarro.nagp.assignment.orderservice.model;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -424688033076492589L;

    private int productId;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
