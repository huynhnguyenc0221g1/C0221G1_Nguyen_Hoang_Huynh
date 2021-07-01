package com.phone_management.model.service;

import com.phone_management.model.entity.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);

    void update(Smartphone smartPhone);
}