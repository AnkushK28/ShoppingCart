package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoy extends JpaRepository<Customer, Long>
{
}
