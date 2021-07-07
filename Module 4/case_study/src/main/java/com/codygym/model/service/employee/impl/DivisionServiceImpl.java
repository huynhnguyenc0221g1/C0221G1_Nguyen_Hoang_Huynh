package com.codygym.model.service.employee.impl;

import com.codygym.model.entity.employee.Division;
import com.codygym.model.repository.employee.IDivisionRepository;
import com.codygym.model.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Division division) {
    }

    @Override
    public void remove(Integer id) {
    }
}
