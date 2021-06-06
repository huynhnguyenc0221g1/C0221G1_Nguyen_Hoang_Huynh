package model.repository;

import model.bean.AdditionalService;
import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdditionalServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String UPDATE_ADDITIONAL_SERVICE = "UPDATE `additional_service` SET `additional_service_name` = ?, `additional_service_price` = ?, `additional_service_unit` = ? , `additional_service_availability_status` = ? WHERE (`additional_service_id` = ?);";
    final String SELECT_ADDITIONAL_SERVICE_BY_ID = "select * from additional_service where additional_service_id = ?;";
    public boolean updateAdditionalService(AdditionalService additionalService) {
        Connection connection = baseRepository.connectDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDITIONAL_SERVICE);
            preparedStatement.setString(1, additionalService.getName());
            preparedStatement.setDouble(2, additionalService.getPrice());
            preparedStatement.setInt(3, additionalService.getUnit());
            preparedStatement.setString(4, additionalService.getStatus());
            preparedStatement.setInt(5, additionalService.getId());
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public AdditionalService selectAdditionalService(int inputID) {
        Connection connection = baseRepository.connectDatabase();
        AdditionalService additionalService = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDITIONAL_SERVICE_BY_ID);
            preparedStatement.setInt(1, inputID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("additional_service_id");
                String name = resultSet.getString("additional_service_name");
                double price = resultSet.getDouble("additional_service_price");
                int unit = resultSet.getInt("additional_service_unit");
                String status = resultSet.getString("additional_service_availability_status");
                additionalService = new AdditionalService(id,name,price,unit,status);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return additionalService;
    }
}
