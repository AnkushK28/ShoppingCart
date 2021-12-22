package com.example.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
        @NotBlank(message = "Topping name can not be null")
        private String ToppingName;
        @NotBlank(message = "Price can not be null")
        private float price;
        @ManyToMany(targetEntity = Pizza.class, mappedBy = "toppings", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Pizza> pizzas;

}
