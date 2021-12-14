package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Order;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class OrderController
{
    @Autowired
    OrderService orderService;
    @GetMapping("/allorders")
    public ResponseEntity<List<Order>> getAllPizza() {
        try {
            List<Order> orders= orderService.getAllOrder();

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
