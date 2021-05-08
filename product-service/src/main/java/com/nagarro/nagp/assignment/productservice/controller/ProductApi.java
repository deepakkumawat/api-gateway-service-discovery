package com.nagarro.nagp.assignment.productservice.controller;


import com.nagarro.nagp.assignment.productservice.model.Product;
import com.nagarro.nagp.assignment.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    ProductService productService;

    @GetMapping("/{product-id}")
    public Product getProduct(@PathVariable(value = "product-id") int productId) {
        return productService.getProduct(productId);
    }
}
