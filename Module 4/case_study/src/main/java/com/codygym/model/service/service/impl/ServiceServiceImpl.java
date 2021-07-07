package com.codygym.model.service.service.impl;

import com.codygym.model.entity.service.Service;
import com.codygym.model.repository.service.IServiceRepository;
import com.codygym.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findByServiceNameContaining(String name, Pageable pageable) {
        return serviceRepository.findByServiceNameContaining(name,pageable);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }
}
