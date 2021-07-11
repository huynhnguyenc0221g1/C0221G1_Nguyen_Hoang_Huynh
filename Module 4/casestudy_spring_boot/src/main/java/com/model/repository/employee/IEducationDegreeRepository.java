package com.model.repository.employee;

import com.model.entity.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<Education,Long> {
}
