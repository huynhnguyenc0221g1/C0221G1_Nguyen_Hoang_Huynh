package com.model.service.impl;

import com.model.entity.employee.Division;
import com.model.entity.employee.Education;
import com.model.entity.employee.Employee;
import com.model.entity.employee.Position;
import com.model.repository.employee.IDivisionRepository;
import com.model.repository.employee.IEducationDegreeRepository;
import com.model.repository.employee.IEmployeeRepository;
import com.model.repository.employee.IPositionRepository;
import com.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IDivisionRepository divisionRepository;
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<Division> listDivision() {
        return this.divisionRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return this.positionRepository.findAll();
    }

    @Override
    public List<Education> listEducation() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(String keyWord, Pageable pageable) {
        return this.employeeRepository.findAllByKeyWord(keyWord, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        Employee employee=this.findById(id);
        employee.setFlag(false);
        save(employee);
    }
}
