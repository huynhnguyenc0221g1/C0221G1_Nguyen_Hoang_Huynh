package model.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    Connection connectDatabase(){
        final String URL = "jdbc:mysql://localhost:3306/employee_management?allowPublicKeyRetrieval=true&useSSL=false";
        final String USER = "root";
        final String PASSWORD = "Nguyentuan41!";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
