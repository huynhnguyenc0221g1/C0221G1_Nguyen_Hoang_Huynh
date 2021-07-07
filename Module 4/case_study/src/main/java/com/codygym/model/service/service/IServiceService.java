package com.codygym.model.service.service;

import com.codygym.model.entity.service.Service;
import com.codygym.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService extends IGenericService<Service> {
    Page<Service> findByServiceNameContaining(String name, Pageable pageable);
    Page<Service> findAll(Pageable pageable);
}