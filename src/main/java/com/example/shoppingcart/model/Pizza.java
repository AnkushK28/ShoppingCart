package com.example.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @NotBlank(message = "pizzaname can not be null")
    private String pizzaName;
    @NotBlank(message = "pizzatype can not be null")
    private String pizzaType;
    @NotBlank(message = "pizzasize can not be null")
    private String pizzaSize;
    @NotBlank(message = "price can not be null")
    private float price;
    @ManyToMany(targetEntity = Topping.class,cascade = CascadeType.ALL )
    private List<Topping> toppings;


//    @ManyToOne
//    @JoinColumn(name = "order_Id")
//    private Order order;

}
