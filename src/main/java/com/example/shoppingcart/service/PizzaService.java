package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.repository.PizzaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public List<Pizza> getAllPizza()
    {
        return pizzaRepository.findAll();
    }
    public Pizza getByPizzaName(String name)
    {
        return pizzaRepository.findByPizzaName(name);
    }
    public List<Pizza> getByPizzType(String type)
    {
        return pizzaRepository.findByPizzaType(type);
    }
    public Pizza update(Pizza pizza) {
        Pizza pizza1 = null;
        try {
           // employee1 = repository.findById(employee.getEmployeeId()).orElseThrow(() -> new Exception("employee not Exist"));
            pizza1 = pizzaRepository.findById(pizza.getId()).orElseThrow(()->new Exception("pizza not exist"));
            pizza1.setPizzaName(pizza.getPizzaName());
            pizza1.setPizzaSize(pizza.getPizzaSize());
            pizza1.setPizzaType(pizza.getPizzaType());
            pizza1.setPrice(pizza.getPrice());
            pizza1.setToppings(pizza.getToppings());
            return pizzaRepository.save(pizza1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizza1;
    }
//    public Pizza getpizza(String pizzaName)
//    {
//      return  pizzaRepository.findByPizzaName(pizzaName);
//   }

}
