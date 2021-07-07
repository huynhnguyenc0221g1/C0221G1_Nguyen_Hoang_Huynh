package com.codygym.model.service.employee.impl;

import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.repository.employee.IEducationRepository;
import com.codygym.model.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;
    @Override
    public Iterable<EducationDegree> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(EducationDegree educationDegree) {
    }

    @Override
    public void remove(Integer id) {
    }
}
