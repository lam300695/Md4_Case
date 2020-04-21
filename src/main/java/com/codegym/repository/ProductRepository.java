package com.codegym.repository;

import com.codegym.model.Product;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);


    Page<Product> findAllByType_TypeName(String typeName, Pageable pageable);

    Page<Product> findAllByOrderByProductPriceAsc(Pageable pageable);

    Page<Product> findAllByOrderByProductPriceDesc(Pageable pageable);


}
