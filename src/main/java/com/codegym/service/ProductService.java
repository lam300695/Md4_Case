package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface ProductService {

    public Page<Product> findAll(Pageable pageable);

    public Product findById(Long id);

    public void save(Product product);

    public void remove(Long id);

    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);

    Page<Product> findAllByType_TypeName(String typeName, Pageable pageable);

    Page<Product> findAllByOrderByProductPriceAsc(Pageable pageable);

    Page<Product> findAllByOrderByProductPriceDesc(Pageable pageable);


}
