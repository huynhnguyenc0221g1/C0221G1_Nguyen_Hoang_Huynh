package com.codygym.model.service.employee.impl;

import com.codygym.model.entity.employee.Position;
import com.codygym.model.repository.employee.IPositionRepository;
import com.codygym.model.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Position position) {
    }

    @Override
    public void remove(Integer id) {
    }
}