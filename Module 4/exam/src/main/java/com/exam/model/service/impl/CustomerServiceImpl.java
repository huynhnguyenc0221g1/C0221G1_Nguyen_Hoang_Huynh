package com.exam.model.service.impl;

import com.exam.model.entity.Customer;
import com.exam.model.entity.CustomerType;
import com.exam.model.repository.ICustomerRepository;
import com.exam.model.repository.ICustomerTypeRepository;
import com.exam.model.service.ICustomerService;
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
