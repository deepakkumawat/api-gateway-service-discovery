package com.nagarro.nagp.assignment.orderservice.model;

import java.io.Serializable;

@lombok.Setter
@lombok.Getter
@lombok.Builder
public class Order implements Serializable {

    private static final long serialVersionUID = -424688033076492589L;

    private int orderId;
    private Product product;
    private User user;
    private int quantity;
    private double total;

}
