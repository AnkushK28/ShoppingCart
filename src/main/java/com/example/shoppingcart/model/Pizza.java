package com.example.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Pizza implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String pizzaName;
    private String pizzaType;
    private String pizzaSize;
    private float price;
    @ManyToMany(targetEntity = Topping.class,cascade = CascadeType.ALL )
    private List<Topping> toppings;

//    @ManyToOne
//    @JoinColumn(name = "order_Id")
//    private Order order;

}
