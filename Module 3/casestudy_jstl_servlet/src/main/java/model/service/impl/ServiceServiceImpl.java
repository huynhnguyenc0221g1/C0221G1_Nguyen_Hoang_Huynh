package model.service.impl;

import model.bean.RentOption;
import model.bean.Service;
import model.bean.ServiceType;
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

    @Override
    public boolean updateService(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public Service selectServiceById(int id) {
        return serviceRepository.selectService(id);
    }

    @Override
    public List<ServiceType> selectAllServiceTypes() {
        return serviceRepository.selectAllServiceTypes();
    }

    @Override
    public List<RentOption> selectAllRentOption() {
        return serviceRepository.selectAllRentOption();
    }
}
