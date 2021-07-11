package com.model.service.impl;

import com.model.entity.service.RentType;
import com.model.entity.service.Service;
import com.model.entity.service.ServiceType;
import com.model.repository.service.IRentTypeRepository;
import com.model.repository.service.IServiceRepository;
import com.model.repository.service.IServiceTypeRepository;
import com.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImpl implements IService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public Page<Service> findAll(String keyWord, Pageable pageable) {
        return this.serviceRepository.findAllByKeyWord(keyWord, pageable);
    }

    @Override
    public Service findById(Long id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
         this.serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<RentType> listRentType() {
        return this.rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> listServiceType() {
        return this.serviceTypeRepository.findAll();
    }
}
