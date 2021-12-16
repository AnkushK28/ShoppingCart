package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Order;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService
{
    @Autowired
    OrderRepository orderRepository;


    public List<Order> getAllOrder()
    {
        return orderRepository.findAll();
    }


    public Order save(Order order)
    {
        return orderRepository.save(order);
    }

        public Order bookPizzaOrder(Order order)
        {
        return orderRepository.save(order);
    }
}
