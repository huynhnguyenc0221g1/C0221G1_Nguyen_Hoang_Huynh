package com.codygym.model.service.customer;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenericService<Customer> {
    Page<Customer> findByCustomerNameContaining(String name, Pageable pageable);
}