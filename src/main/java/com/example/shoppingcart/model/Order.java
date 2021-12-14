package com.example.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
//    @ManyToOne
//    @JoinColumn(name = "customer_ID")
//    private Customer customer;
    private double finalPrice;
    private Boolean status;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , mappedBy = "order")
//    private List<Pizza> pizzalist ;

}
