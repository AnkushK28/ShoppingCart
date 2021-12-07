package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoy extends JpaRepository<Customer, Long> {
}
