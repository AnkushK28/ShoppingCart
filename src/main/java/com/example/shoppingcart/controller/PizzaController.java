package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.repository.PizzaRepository;
import com.example.shoppingcart.repository.ToppingRepository;
import com.example.shoppingcart.service.PizzaService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController
{
    @Autowired
    PizzaService pizzaService;
    @Autowired
    PizzaRepository pizzaRepository;
    @PostMapping("/addPizza")
    @ResponseBody
    public Pizza add(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    @GetMapping("/GetallPizza")
    public ResponseEntity<List<Pizza>> getAllPizza() {
        try {
            List<Pizza> pizzas= pizzaService.getAllPizza();

            if (pizzas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pizzas,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public String deletePizza(String pizzid) {
//        Employee employee = employeeRepo.findByEmployeeId(empId);
//        if (!ObjectUtils.isEmpty(employee)) {
//            employeeRepo.delete(employee);
//            return " Record deleted = " + employee;
//        } else
//            return "Record is not available and not deleted";
//    }
//    public Pizza getPizzaByName(String pizzaName)
//    {
//        return pizzaService.getpizza(pizzaName)   ;
//    }

    @GetMapping("/FindPizzaByName/{name}")
    public ResponseEntity<List<Pizza>> getPizzaByName(@PathVariable String name)
    {
        return new ResponseEntity<List<Pizza>>(pizzaRepository.findByPizzaName(name), HttpStatus.OK);
    }
    @GetMapping("/FindPizzaByType/{pizzaType}")
    public ResponseEntity<List<Pizza>> getPizzaByPizzaType(@PathVariable String PizzaType)
    {
        return new ResponseEntity<List<Pizza>>(pizzaRepository.findPizzaByPizzaType(PizzaType), HttpStatus.OK);
    }
}
