package com.model.service;

import com.model.entity.customer.Customer;
import com.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IGenerateService<Customer> {
    List<CustomerType> listCustomerType();
}
