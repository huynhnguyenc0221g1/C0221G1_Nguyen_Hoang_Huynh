package model.service;

import model.bean.Department;
import model.bean.Employee;
import model.bean.Position;
import model.bean.Qualification;

import java.util.List;

public interface IEmployeeService {
    public void insertEmployee(Employee employee);
    public Employee selectEmployee(int id);
    public List<Employee> selectAllEmployee();
    public boolean deleteEmployee(int id);
    public boolean updateEmployee(Employee employee);
    public List<Employee> findByName(String name);
    public List<Position> selectAllPositions();
    public List<Qualification> selectAllQualifications();
    public List<Department> selectAllDepartments();
}

