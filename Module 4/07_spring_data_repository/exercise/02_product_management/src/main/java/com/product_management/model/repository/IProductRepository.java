package com.product_management.model.repository;

import com.product_management.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from product p  where p.name like %?1% ")
    Page<Product> findAllByNameSearch(String nameSearch, Pageable pageable);
}
