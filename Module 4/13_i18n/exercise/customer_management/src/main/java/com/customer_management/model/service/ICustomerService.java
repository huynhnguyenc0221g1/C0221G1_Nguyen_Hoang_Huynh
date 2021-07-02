package com.customer_management.model.service;

import com.customer_management.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(Integer id);
    void delete(Integer id);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
