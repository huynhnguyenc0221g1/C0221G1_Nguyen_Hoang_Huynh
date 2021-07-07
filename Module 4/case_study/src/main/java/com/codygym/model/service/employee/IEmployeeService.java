package com.codygym.model.service.employee;

import com.codygym.model.entity.employee.Employee;
import com.codygym.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGenericService<Employee> {
    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);
}
