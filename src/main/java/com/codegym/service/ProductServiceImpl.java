package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.Type;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String productName, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(productName, pageable);
    }

    @Override
    public Page<Product> findAllByType_TypeName(String typeName, Pageable pageable) {
        return productRepository.findAllByType_TypeName( typeName, pageable);
    }


}
