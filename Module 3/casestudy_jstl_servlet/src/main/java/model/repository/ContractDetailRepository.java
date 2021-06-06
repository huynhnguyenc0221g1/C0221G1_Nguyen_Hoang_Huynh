package model.repository;

import model.bean.AdditionalService;
import model.bean.Contract;
import model.bean.ContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String DISABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=0";
    final String ENABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=1";
    final String INSERT_CONTRACT_DETAIL = "INSERT INTO `furama_resort`.`contract_detail` (`contract_detail_id`, `contract_id`, `additional_service_id`, `contract_detail_amount`) VALUES (?, ?, ?, ?);";
    final String SELECT_ALL_ADDITIONAL_SERVICE = "select * from additional_service";

    public void insertContractDetail(ContractDetail contractDetail) {
        Connection connection = baseRepository.connectDatabase();
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1,contractDetail.getId());
            preparedStatement.setInt(2,contractDetail.getContractId());
            preparedStatement.setInt(3,contractDetail.getAdditionalServiceId());
            preparedStatement.setInt(4,contractDetail.getAmount());
            preparedStatement.executeUpdate();
            Statement enableForeignKeyCheck = connection.createStatement();
            enableForeignKeyCheck.execute(ENABLE_FOREIGN_KEY_CHECK);
            enableForeignKeyCheck.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<AdditionalService> selectAllAdditionalServices() {
        Connection connection = baseRepository.connectDatabase();
        List<AdditionalService> additionalServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDITIONAL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("additional_service_id");
                String name = resultSet.getString("additional_service_name");
                double price = resultSet.getDouble("additional_service_price");
                int unit = resultSet.getInt("additional_service_unit");
                String status = resultSet.getString("additional_service_availability_status");
                additionalServiceList.add(new AdditionalService(id,name,price,unit,status));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return additionalServiceList;
    }
}
