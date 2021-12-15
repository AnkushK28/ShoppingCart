package com.example.shoppingcart.model;

import lombok.Data;

import javax.persistence.*;
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
    private Boolean status;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "orderId")
//    private int orderId;
////    @ManyToOne
////    @JoinColumn(name = "customer_ID")
////    private Customer customer;
//@Column(name = "finalPrice")
//    private double finalPrice;
//    @Column(name = "status")
//    private Boolean status;
//
//
//    public String getOrderID() {
//        return orderID;
//    }
//
//    public void setOrderID(String orderID) {
//        this.orderID = orderID;
//    }
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , mappedBy = "order")
//    private List<Pizza> pizzalist ;

}
