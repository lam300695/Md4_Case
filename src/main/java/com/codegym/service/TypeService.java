package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    Iterable<Type> findAll();
    public Type findById(Long id);
    public void save(Type type);
    public void remove(Long id);
}
