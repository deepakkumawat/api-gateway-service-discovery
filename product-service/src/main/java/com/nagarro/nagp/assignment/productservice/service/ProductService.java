package com.nagarro.nagp.assignment.productservice.service;

import com.nagarro.nagp.assignment.productservice.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private static final Map<Integer, Product> PRODUCT_DB = new HashMap<>();

    @PostConstruct
    public void initUserDB(){
        PRODUCT_DB.put(1, new Product(1, "Phone", 20000));
        PRODUCT_DB.put(2, new Product(2, "Laptop", 30000));
    }

    public Product getProduct(int productId){
        return PRODUCT_DB.get(productId);
    }
}
