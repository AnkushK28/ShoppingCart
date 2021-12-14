package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PizzaService
{
    @Autowired
    PizzaRepository pizzaRepository;
    public Pizza addPizza(Pizza pizza)
    {
        return pizzaRepository.save(pizza) ;
    }
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }
//    public Pizza getpizza(String pizzaName)
//    {
//      return  pizzaRepository.findByPizzaName(pizzaName);
//   }

}
