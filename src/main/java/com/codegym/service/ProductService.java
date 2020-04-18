package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Page<Product> findAll(Pageable pageable);
    public Product findById(Long id);
    public void save(Product product);
    public void remove(Long id);

    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);
}
