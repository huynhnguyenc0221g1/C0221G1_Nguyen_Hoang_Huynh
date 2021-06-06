package model.service;

import model.bean.Customer;
import model.bean.CustomerType;

import java.util.List;

public interface ICustomerService {
    public void insertCustomer(Customer customer);
    public Customer selectCustomer(int id);
    public List<Customer> selectAllCustomer();
    public boolean deleteCustomer(int id);
    public boolean updateCustomer(Customer customer);
    public List<Customer> findByName(String name);
    public List<CustomerType> selectAllCustomerTypes();
}
