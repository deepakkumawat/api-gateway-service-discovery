package com.nagarro.nagp.assignment.orderservice.controller;


import com.nagarro.nagp.assignment.orderservice.model.CreateOrderRequest;
import com.nagarro.nagp.assignment.orderservice.model.Order;
import com.nagarro.nagp.assignment.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @GetMapping("/{order-id}")
    public Order getOrder(@PathVariable(value = "order-id") int orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping
    public int saveOrder(@Valid @RequestBody CreateOrderRequest order) {
        return orderService.saveOrder(order);
    }
}
