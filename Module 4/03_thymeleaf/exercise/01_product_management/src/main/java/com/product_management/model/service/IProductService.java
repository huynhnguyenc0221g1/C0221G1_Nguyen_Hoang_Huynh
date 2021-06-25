package com.product_management.model.service;

import com.product_management.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(String nameSearch, Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
