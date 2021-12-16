package com.example.shoppingcart.model;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name="orders")
public class Order
{
    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "final_price")
    private Double finalPrice;

    @Column(name = "status")
    private String status;

    private Long customerID;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="id")
//    private List<Pizza> pizza;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
