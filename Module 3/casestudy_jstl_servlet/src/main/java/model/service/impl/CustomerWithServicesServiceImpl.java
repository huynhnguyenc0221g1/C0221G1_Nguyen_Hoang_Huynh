package model.service.impl;

import model.bean.CustomerWithServices;
import model.repository.CustomerWithServicesRepository;
import model.service.ICustomerWithServicesService;

import java.util.List;

public class CustomerWithServicesServiceImpl implements ICustomerWithServicesService {
    CustomerWithServicesRepository customerWithServicesRepository = new CustomerWithServicesRepository();
    @Override
    public List<CustomerWithServices> selectAllCustomerWithServices() {
        return customerWithServicesRepository.selectAllCustomerWithServices();
    }
}
