package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productDicri;
    private String productImage;
    private String productPrice;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Product() {
    }

    public Product(Long id, String productName, String productDicri, String productImage, String productPrice) {
        this.id = id;
        this.productName = productName;
        this.productDicri = productDicri;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDicri() {
        return productDicri;
    }

    public void setProductDicri(String productDicri) {
        this.productDicri = productDicri;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
