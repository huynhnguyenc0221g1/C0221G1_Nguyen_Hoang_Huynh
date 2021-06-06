package model.repository;

import model.bean.RentOption;
import model.bean.Service;
import model.bean.ServiceType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String DISABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=0";
    final String ENABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=1";
    final String INSERT_SERVICE = "INSERT INTO `service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_inhouse`, `rent_option_id`, `service_type_id`, `service_room_standard`, `service_other_convenience`, `service_pool_area`, `service_number_of_floor`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    final String SELECT_ALL_SERVICE = "select * from `service`;";

    final String SELECT_ALL_SERVICE_TYPE = "select * from service_type;";
    final String SELECT_ALL_RENT_OPTION ="select * from rent_option;";

    public void insertService(Service service){
        Connection connection = baseRepository.connectDatabase();
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
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
            Statement enableForeignKeyCheck = connection.createStatement();
            enableForeignKeyCheck.execute(ENABLE_FOREIGN_KEY_CHECK);
            enableForeignKeyCheck.close();
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

    public List<ServiceType> selectAllServiceTypes() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            Connection connection = baseRepository.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return serviceTypeList;
    }

    public List<RentOption> selectAllRentOption() {
        List<RentOption> rentOptionList = new ArrayList<>();
        try {
            Connection connection = baseRepository.connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_OPTION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("rent_option_id");
                String name = resultSet.getString("rent_option_name");
                double price = resultSet.getDouble("rent_price");
                rentOptionList.add(new RentOption(id,name,price));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rentOptionList;
    }
}