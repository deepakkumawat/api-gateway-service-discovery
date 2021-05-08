package com.nagarro.nagp.assignment.orderservice.model;

@lombok.Setter
@lombok.Getter
public class CreateOrderRequest {
    private int productId;
    private int quantity;
    private int userId;
}
