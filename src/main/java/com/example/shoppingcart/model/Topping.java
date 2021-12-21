package com.example.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
public class Topping {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long ToppingId;
        private String ToppingName;
        private float price;

        @ManyToMany(targetEntity = Pizza.class, mappedBy = "toppings", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Pizza> pizzas;

}
