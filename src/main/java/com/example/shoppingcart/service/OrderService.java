package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Order;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService
{
    @Autowired
    OrderRepository orderRepository;
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
