package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "productOrderDetail")
public class ProductOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ShoppingCart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    private int quantity;

    public ProductOrderDetail() {
    }

    public ProductOrderDetail(ShoppingCart shoppingCart, Product product, int quantity) {
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}