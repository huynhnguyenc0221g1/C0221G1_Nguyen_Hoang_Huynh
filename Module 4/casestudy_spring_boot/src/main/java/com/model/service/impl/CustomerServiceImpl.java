package com.model.service.impl;

import com.model.entity.customer.Customer;
import com.model.entity.customer.CustomerType;
import com.model.repository.customer.ICustomerRepository;
import com.model.repository.customer.ICustomerTypeRepository;
import com.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAll(String keyWord, Pageable pageable) {
        return customerRepository.findAllByKeyWord(keyWord, pageable);
    }

    @Override
    public Customer findById(Long id) {
       return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer=this.findById(id);
        customer.setFlag(false);
        save(customer);
    }

    @Override
    public List<CustomerType> listCustomerType() {
        return customerTypeRepository.findAll();
    }
}

