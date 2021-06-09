package model.repository;

import model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String DISABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=0";
    final String ENABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=1";
    final String INSERT_EMPLOYEE = "INSERT INTO employee (`id`, `name`, `birthdate`) values (?,?,?);";
    final String SELECT_EMPLOYEE_BY_ID = "select * from employee\n" +
            "where `id`=?;";
    final String SELECT_ALL_EMPLOYEE = "select * from employee;";
    final String DELETE_EMPLOYEE = "delete from `employee` where `id`=?;";
    final String UPDATE_EMPLOYEE = "update `employee` set name = ?,birthdate = ? where `id` =?;";
    final String FIND_BY_NAME = "select * from `employee` where `name` like ?;";

    public void insertEmployee(Employee employee) {
        Connection connection = baseRepository.connectDatabase();
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getBirthdate());
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
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthdate = resultSet.getString("birthdate");
                employee = new Employee(id, name,birthdate);
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
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthdate = resultSet.getString("birthdate");
                Employee employee = new Employee(id, name, birthdate);
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
            preparedStatement.setString(2, employee.getBirthdate());
            preparedStatement.setInt(3, employee.getId());
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
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthdate = resultSet.getString("birthdate");
                Employee employee = new Employee(id, name, birthdate);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


}
