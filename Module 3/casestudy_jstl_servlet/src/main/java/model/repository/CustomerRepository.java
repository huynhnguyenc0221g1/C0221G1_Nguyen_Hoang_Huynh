package model.repository;

import model.bean.Customer;
import model.bean.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String INSERT_CUSTOMER = "INSERT INTO customer (customer_id,customer_code, customer_type_id, customer_fullname, customer_birthdate, customer_gender, customer_id_number, customer_phone_number, customer_email, customer_address) values (?,?,?,?,?,?,?,?,?,?);";
    final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer.customer_id=?;";
    final String SELECT_ALL_CUSTOMER = "select * from customer;";
    final String DELETE_CUSTOMER = "delete from `customer` where customer_id=?;";
    final String UPDATE_CUSTOMER = "update `customer` set customer_code = ?, customer_type_id = ?, customer_fullname = ?, customer_birthdate = ?, customer_gender = ?, customer_id_number = ?, customer_phone_number = ?, customer_email = ? , customer_address = ? where customer_id =?;";
    final String FIND_BY_NAME = "select * from `customer` where customer_fullname like ?;";
    final String SELECT_ALL_CUSTOMER_TYPES = "select * from customer_type";
    public void insertCustomer(Customer customer){
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getCode());
            preparedStatement.setInt(3, customer.getTypeId());
            preparedStatement.setString(4, customer.getName());
            preparedStatement.setString(5, customer.getBirthdate());
            preparedStatement.setByte(6, customer.getGender());
            preparedStatement.setString(7, customer.getIdNumber());
            preparedStatement.setString(8, customer.getPhoneNumber());
            preparedStatement.setString(9, customer.getEmail());
            preparedStatement.setString(10, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer selectCustomer(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_fullname");
                String birthdate = resultSet.getString("customer_birthdate");
                byte gender = resultSet.getByte("customer_gender");
                String idNumber = resultSet.getString("customer_id_number");
                String phone_number = resultSet.getString("customer_phone_number");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,code,typeId,name,birthdate,gender,idNumber,phone_number,email,address);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> selectAllCustomers() {
        Connection connection = baseRepository.connectDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_fullname");
                String birthdate = resultSet.getString("customer_birthdate");
                byte gender = resultSet.getByte("customer_gender");
                String idNumber = resultSet.getString("customer_id_number");
                String phoneNumber = resultSet.getString("customer_phone_number");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Customer customer = new Customer(id,code,typeId,name,birthdate,gender,idNumber,phoneNumber,email,address);
                customerList.add(customer);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean deleteCustomer(int id) {
        Connection connection = baseRepository.connectDatabase();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public boolean updateCustomer(Customer customer) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCode());
            preparedStatement.setInt(2, customer.getTypeId());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getBirthdate());
            preparedStatement.setByte(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdNumber());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.setInt(10,customer.getId());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Customer> findByName(String inputName) {
        Connection connection = baseRepository.connectDatabase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1,"%"+inputName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_fullname");
                String birthdate = resultSet.getString("customer_birthdate");
                byte gender = resultSet.getByte("customer_gender");
                String idNumber = resultSet.getString("customer_id_number");
                String phoneNumber = resultSet.getString("customer_phone_number");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Customer customer = new Customer(id,code,typeId,name,birthdate,gender,idNumber,phoneNumber,email,address);
                customerList.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public List<CustomerType> selectAllCustomerTypes() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            Connection connection = baseRepository.connectDatabase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}
