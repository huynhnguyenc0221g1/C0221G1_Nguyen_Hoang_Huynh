package com.codygym.model.service.service.impl;

import com.codygym.model.entity.service.RentType;
import com.codygym.model.repository.service.IRentTypeRepository;
import com.codygym.model.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {
    }

    @Override
    public void remove(Integer id) {
    }
}