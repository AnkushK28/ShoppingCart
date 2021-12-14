package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ToppingRepository extends JpaRepository<Topping,Long>
{
  // Topping findByToppingName(String ToppingName);

}
