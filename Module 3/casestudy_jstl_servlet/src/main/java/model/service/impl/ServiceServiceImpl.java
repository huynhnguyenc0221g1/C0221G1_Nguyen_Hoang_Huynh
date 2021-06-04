package model.service.impl;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.service.IServiceService;

import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public void insertService(Service service) {
        serviceRepository.insertService(service);
    }

    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }
}
