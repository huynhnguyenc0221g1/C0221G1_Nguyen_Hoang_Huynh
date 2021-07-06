package com.codygym.model.service;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    Page<Customer> findByName(String name, Pageable pageable);

    void save(Customer customer);

    void remove(Long id);

    List<CustomerType> findAllCustomerType();

}
