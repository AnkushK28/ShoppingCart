package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Pizza;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>
{
    List<Pizza> findByPizzaName(String pizzaName);
    List<Pizza> findPizzaByPizzaType(String pizzaType);
}
