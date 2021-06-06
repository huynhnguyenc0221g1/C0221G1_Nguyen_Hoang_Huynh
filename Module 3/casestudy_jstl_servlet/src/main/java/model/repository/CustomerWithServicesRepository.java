package model.repository;


import model.bean.CustomerWithServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerWithServicesRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_CUSTOMER_WITH_SERVICES = "select customer.customer_id,customer.customer_fullname,contract.contract_id,contract.contract_made_date,contract.contract_end_date,contract_detail.contract_detail_id,additional_service.additional_service_id,additional_service.additional_service_name\n" +
            "from customer\n" +
            "join contract\n" +
            "on contract.customer_id = customer.customer_id\n" +
            "left outer join contract_detail\n" +
            "on contract_detail.contract_id = contract.contract_id\n" +
            "left outer join additional_service\n" +
            "on contract_detail.additional_service_id = additional_service.additional_service_id;";

    public List<CustomerWithServices> selectAllCustomerWithServices() {
        Connection connection = baseRepository.connectDatabase();
        List<CustomerWithServices> customerWithServicesList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_WITH_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_fullname");
                int contractId = resultSet.getInt("contract_id");
                String contractMadeDate = resultSet.getString("contract_made_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int additionalServiceId = resultSet.getInt("additional_service_id");
                String additionalServiceName = resultSet.getString("additional_service_name");
                CustomerWithServices customerWithServices = new CustomerWithServices(customerId,customerName,contractId,contractMadeDate,contractEndDate,contractDetailId,additionalServiceId,additionalServiceName);
                customerWithServicesList.add(customerWithServices);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerWithServicesList;
    }
}
