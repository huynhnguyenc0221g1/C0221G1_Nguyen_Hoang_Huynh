package com.customer_management.model.repository;

import com.customer_management.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province,Integer> {
}
