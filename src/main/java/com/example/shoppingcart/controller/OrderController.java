package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Order;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
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
    @PostMapping("/makeorder")
    public Order makeOrder(@RequestParam("customerID") Long customerID,@RequestParam("status") String status, @RequestParam("finalPrice") Double finalPrice)
    {
        Order order= new Order();
        order.setFinalPrice(finalPrice);
        order.setStatus(status);
//        order.setPizzaID(pizzaID);
        order.setCustomerID(customerID);
        order.setDate(LocalDate.now());
        return orderService.save(order);
    }
    @PostMapping("/bookpizzaorders")  //http://localhost:1220/pizzaorders/bookpizzaorders
    public ResponseEntity<Boolean> bookpizzaorder(@RequestBody Order order)
    {
        Order entity =orderService.bookPizzaOrder(order);
        ResponseEntity<Boolean> responseEntity=new ResponseEntity<>(true, HttpStatus.OK);
        return responseEntity;
    }
}