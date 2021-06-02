package model.repository;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String INSERT_USERS = "insert into users(name,email,country) values(?,?,?);";
    final String SELECT_USERS_BY_ID = "select* from users\n" +
            "where id=?;";
    final String SELECT_ALL_USER_SP ="call list_user_procedure();";
    final String UPDATE_USER_BY_ID_SP ="call update_user_procedure(?,?,?,?);";
    final String DELETE_USER_BY_ID_SP = "call delete_user_procedure(?);";

    public void insertUser(User user) {
        Connection connection = baseRepository.connectDatabase();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User selectUser(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        Connection connection = baseRepository.connectDatabase();
        List<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USER_SP);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean deleteUser(int id) {
        Connection connection = baseRepository.connectDatabase();
        boolean rowDelete = false;
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER_BY_ID_SP);
            callableStatement.setInt(1, id);
            rowDelete = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    public boolean updateUser(User user) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USER_BY_ID_SP);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}