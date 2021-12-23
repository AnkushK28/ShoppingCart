package com.example.shoppingcart.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order
{

    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @NotBlank
    @Column(name = "final_price")
    private Double finalPrice;
    @NotNull
    @Column(name = "status")
    private String status;
    @NotNull
    private Long customerID;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="id")
//    private List<Pizza> pizza;
    @Pattern(regexp = "yyyy-MM-dd")
    private LocalDate date;
//
//  @OneToMany
//    @JoinColumn(name = "pizza_id")
//  private List<Pizza> pizza;



}
