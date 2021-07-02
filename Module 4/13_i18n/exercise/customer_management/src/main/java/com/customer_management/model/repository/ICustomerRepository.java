package com.customer_management.model.repository;

import com.customer_management.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String firstname, Pageable pageable);
}
