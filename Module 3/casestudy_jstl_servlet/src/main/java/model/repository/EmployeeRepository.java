package model.repository;

import model.bean.Department;
import model.bean.Employee;
import model.bean.Position;
import model.bean.Qualification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String DISABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=0";
    final String ENABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=1";
    final String INSERT_EMPLOYEE = "INSERT INTO employee (`employee_id`, `employee_name`, `position_id`, `qualification_id`, `department_id`, `employee_birthdate`, `employee_id_number`, `employee_salary`, `employee_phone_number`, `employee_email`, `employee_address`, `username`) values (?,?,?,?,?,?,?,?,?,?,?,?);";
    final String SELECT_EMPLOYEE_BY_ID = "select * from employee\n" +
            "where employee_id=?;";
    final String SELECT_ALL_EMPLOYEE = "select * from employee;";
    final String DELETE_EMPLOYEE = "delete from `employee` where employee_id=?;";
    final String UPDATE_EMPLOYEE = "update `employee` set employee_name = ?, position_id = ?, qualification_id = ?, department_id = ?, employee_birthdate = ?, employee_id_number = ?, employee_salary = ? , employee_phone_number = ?, employee_email = ?, employee_address = ?, username = ? where employee_id =?;";
    final String FIND_BY_NAME = "select * from `employee` where employee_name like ?;";
    final String SELECT_ALL_POSITION = "select * from position;";
    final String SELECT_ALL_QUALIFICATION = "select * from qualification;";
    final String SELECT_ALL_DEPARTMENT = "select * from department;";

    public void insertEmployee(Employee employee) {
        Connection connection = baseRepository.connectDatabase();
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getPositionId());
            preparedStatement.setInt(4, employee.getQualificationId());
            preparedStatement.setInt(5, employee.getDepartmentId());
            preparedStatement.setString(6, employee.getBirthdate());
            preparedStatement.setString(7, employee.getIdNumber());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setString(9, employee.getPhoneNumber());
            preparedStatement.setString(10, employee.getEmail());
            preparedStatement.setString(11, employee.getAddress());
            preparedStatement.setString(12, employee.getUsername());
            preparedStatement.executeUpdate();
            Statement enableForeignKeyCheck = connection.createStatement();
            enableForeignKeyCheck.execute(ENABLE_FOREIGN_KEY_CHECK);
            enableForeignKeyCheck.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee selectEmployee(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                int positionId = resultSet.getInt("position_id");
                int qualificationId = resultSet.getInt("qualification_id");
                int departmentId = resultSet.getInt("department_id");
                String birthdate = resultSet.getString("employee_birthdate");
                String idNumber = resultSet.getString("employee_id_number");
                double salary = resultSet.getDouble("employee_salary");
                String phone_number = resultSet.getString("employee_phone_number");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, positionId, qualificationId, departmentId, birthdate, idNumber, salary, phone_number, email, address, username);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> selectAllEmployee() {
        Connection connection = baseRepository.connectDatabase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                int positionId = resultSet.getInt("position_id");
                int qualificationId = resultSet.getInt("qualification_id");
                int departmentId = resultSet.getInt("department_id");
                String birthdate = resultSet.getString("employee_birthdate");
                String idNumber = resultSet.getString("employee_id_number");
                double salary = resultSet.getDouble("employee_salary");
                String phone_number = resultSet.getString("employee_phone_number");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, positionId, qualificationId, departmentId, birthdate, idNumber, salary, phone_number, email, address, username);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean deleteEmployee(int id) {
        Connection connection = baseRepository.connectDatabase();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public boolean updateEmployee(Employee employee) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getPositionId());
            preparedStatement.setInt(3, employee.getQualificationId());
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setString(5, employee.getBirthdate());
            preparedStatement.setString(6, employee.getIdNumber());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getId());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
            Statement enableForeignKeyCheck = connection.createStatement();
            enableForeignKeyCheck.execute(ENABLE_FOREIGN_KEY_CHECK);
            enableForeignKeyCheck.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Employee> findByName(String inputName) {
        Connection connection = baseRepository.connectDatabase();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + inputName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                int positionId = resultSet.getInt("position_id");
                int qualificationId = resultSet.getInt("qualification_id");
                int departmentId = resultSet.getInt("department_id");
                String birthdate = resultSet.getString("employee_birthdate");
                String idNumber = resultSet.getString("employee_id_number");
                double salary = resultSet.getDouble("employee_salary");
                String phone_number = resultSet.getString("employee_phone_number");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, positionId, qualificationId, departmentId, birthdate, idNumber, salary, phone_number, email, address, username);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Position> selectAllPositions() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("position_id");
                String name =resultSet.getString("position_name");
                positionList.add(new Position(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return positionList;
    }

    public List<Qualification> selectAllQualifications() {
        List<Qualification> qualificationList = new ArrayList<>();
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUALIFICATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("qualification_id");
                String name =resultSet.getString("qualification_name");
                qualificationList.add(new Qualification(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return qualificationList;
    }

    public List<Department> selectAllDepartments() {
        List<Department> departmentList = new ArrayList<>();
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name =resultSet.getString("department_name");
                departmentList.add(new Department(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return departmentList;
    }
}
