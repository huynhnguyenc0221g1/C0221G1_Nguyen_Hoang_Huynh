package model.repository;

import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String INSERT_SERVICE = "INSERT INTO `service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_inhouse`, `rent_option_id`, `service_type_id`, `service_room_standard`, `service_other_convenience`, `service_pool_area`, `service_number_of_floor`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    final String SELECT_ALL_SERVICE = "select * from `service`;";

    public void insertService(Service service){
        Connection connection = baseRepository.connectDatabase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxInHouse());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());
            preparedStatement.setString(8, service.getStandard());
            preparedStatement.setString(9, service.getDescription());
            preparedStatement.setDouble(10, service.getPoolArea());
            preparedStatement.setInt(11, service.getNumberOfFloors());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Service> selectAllService() {
        Connection connection = baseRepository.connectDatabase();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                Double cost = resultSet.getDouble("service_cost");
                int maxInHouse = resultSet.getInt("service_max_inhouse");
                int rentOptionId = resultSet.getInt("rent_option_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standard = resultSet.getString("service_room_standard");
                String description = resultSet.getString("service_other_convenience");
                Double poolArea = resultSet.getDouble("service_pool_area");
                int numberOfFloors = resultSet.getInt("service_number_of_floor");
                Service service = new Service(id,name,area,cost,maxInHouse,rentOptionId,serviceTypeId,standard,description,poolArea,numberOfFloors);
                serviceList.add(service);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }
}