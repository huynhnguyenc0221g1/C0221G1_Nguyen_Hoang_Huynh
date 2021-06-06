package model.service.impl;

import model.bean.Department;
import model.bean.Employee;
import model.bean.Position;
import model.bean.Qualification;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Position> selectAllPositions() {
        return employeeRepository.selectAllPositions();
    }

    @Override
    public List<Qualification> selectAllQualifications() {
        return employeeRepository.selectAllQualifications();
    }

    @Override
    public List<Department> selectAllDepartments() {
        return employeeRepository.selectAllDepartments();
    }
}
