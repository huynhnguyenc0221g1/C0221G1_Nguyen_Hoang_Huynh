package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}
