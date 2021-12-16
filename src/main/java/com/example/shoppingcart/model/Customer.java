package com.example.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;
    private String name;
    private long phone;
    private String email;
    private String address;
}
