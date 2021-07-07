package com.codygym.model.repository.service;

import com.codygym.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}

