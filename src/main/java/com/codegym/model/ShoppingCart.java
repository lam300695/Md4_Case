package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "shoppingCart")
    private List<ProductOrderDetail> productOrderDetails;
    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}