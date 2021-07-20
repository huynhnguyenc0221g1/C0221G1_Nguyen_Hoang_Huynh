package com.exam.model.service;

import com.exam.model.entity.Customer;
import com.exam.model.entity.CustomerType;

import java.util.List;

public interface ICustomerService extends IGenericService<Customer> {
    List<CustomerType> listCustomerType();
}
