package model.service;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeService {
    public void insertEmployee(Employee employee);
    public Employee selectEmployee(int id);
    public List<Employee> selectAllEmployee();
    public boolean deleteEmployee(int id);
    public boolean updateEmployee(Employee employee);
    public List<Employee> findByName(String name);
}

