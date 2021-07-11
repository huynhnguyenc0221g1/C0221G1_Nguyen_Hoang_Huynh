package com.model.service;

import com.model.entity.employee.Division;
import com.model.entity.employee.Education;
import com.model.entity.employee.Employee;
import com.model.entity.employee.Position;

import java.util.List;

public interface IEmployeeService extends IGenerateService<Employee> {
    List<Division> listDivision();

    List<Position> listPosition();

    List<Education> listEducation();
}
