package model.service;

import model.bean.CustomerWithServices;

import java.util.List;

public interface ICustomerWithServicesService {
    public List<CustomerWithServices> selectAllCustomerWithServices();
}
