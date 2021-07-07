package com.codygym.model.repository.service;

import com.codygym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository  extends JpaRepository<Service,Integer> {
    Page<Service> findByServiceNameContaining(String name, Pageable pageable);
    Page<Service> findAll(Pageable pageable);
}
