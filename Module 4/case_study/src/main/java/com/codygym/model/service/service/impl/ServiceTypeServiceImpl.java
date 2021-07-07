package com.codygym.model.service.service.impl;

import com.codygym.model.entity.service.ServiceType;
import com.codygym.model.repository.service.IServiceTypeRepository;
import com.codygym.model.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ServiceType serviceType) {
    }

    @Override
    public void remove(Integer id) {
    }
}
