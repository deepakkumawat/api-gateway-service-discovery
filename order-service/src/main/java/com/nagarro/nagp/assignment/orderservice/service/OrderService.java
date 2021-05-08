package com.nagarro.nagp.assignment.orderservice.service;

import com.nagarro.nagp.assignment.orderservice.exception.ResourceNotFoundException;
import com.nagarro.nagp.assignment.orderservice.model.CreateOrderRequest;
import com.nagarro.nagp.assignment.orderservice.model.Order;
import com.nagarro.nagp.assignment.orderservice.model.Product;
import com.nagarro.nagp.assignment.orderservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    private static final Map<Integer, Order> ORDER_DB = new HashMap<>();

    public Order getOrder(int orderId){
        return ORDER_DB.get(orderId);
    }

    public int saveOrder(CreateOrderRequest createOrderRequest) {
        int orderId = ORDER_DB.size()+1;
        Order order = Order.builder()
                .orderId(orderId)
                .user(getUserDetails(createOrderRequest.getUserId()))
                .product(getProductDetails(createOrderRequest.getProductId()))
                .quantity(createOrderRequest.getQuantity())
                .build();
        processOrderTotal(order);
        ORDER_DB.put(orderId, order);
        return orderId;
    }

    private void processOrderTotal(Order order) {
        if (order.getProduct() != null) {
            order.setTotal(order.getProduct().getPrice() * order.getQuantity());
        }
    }

    private User getUserDetails(int userId) {
        User user = null;
        try {
            //calling user-service by service name
            user = restTemplate.getForObject("http://USER-SERVICE/user/" + userId, User.class);
        } catch (Exception ex) {
            LOGGER.error("Exception occur while fetching data for user: {}", userId, ex);
            throw new ResourceNotFoundException("User", userId, ex.getMessage());
        }
        if (user == null)
            throw new ResourceNotFoundException("User", userId);
        return user;
    }

    private Product getProductDetails(int productId) {
        Product product = null;
        try {
            //calling product-service by service name
            product = restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + productId, Product.class);
        } catch (Exception ex) {
            LOGGER.error("Exception occur while fetching data for product: {}", productId, ex);
            throw new ResourceNotFoundException("Product", productId, ex.getMessage());
        }
        if (product == null)
            throw new ResourceNotFoundException("Product", productId);
        return product;
    }
}
