package com.codygym.model.repository.employee;

import com.codygym.model.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}