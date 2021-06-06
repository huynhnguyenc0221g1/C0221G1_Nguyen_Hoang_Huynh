package model.repository;

import model.bean.Contract;
import model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String DISABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=0";
    final String ENABLE_FOREIGN_KEY_CHECK = "SET FOREIGN_KEY_CHECKS=1";
    final String INSERT_CONTRACT = "INSERT INTO contract (`contract_id`, `employee_id`, `customer_id`, `service_id`, `contract_made_date`, `contract_end_date`, `contract_deposit`, `contract_total`) VALUES (?,?,?,?,?,?,?,?);";
    final String SELECT_ALL_CONTRACT = "select * from contract;";

    public void insertContract(Contract contract) {
        Connection connection = baseRepository.connectDatabase();
        try {
            Statement disableForeignKeyCheck = connection.createStatement();
            disableForeignKeyCheck.execute(DISABLE_FOREIGN_KEY_CHECK);
            disableForeignKeyCheck.close();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
            preparedStatement.setInt(1, contract.getId());
            preparedStatement.setInt(2, contract.getEmployeeId());
            preparedStatement.setInt(3, contract.getCustomerId());
            preparedStatement.setInt(4, contract.getServiceId());
            preparedStatement.setString(5, contract.getMadeDate());
            preparedStatement.setString(6, contract.getEndDate());
            preparedStatement.setDouble(7, contract.getDeposit());
            preparedStatement.setDouble(8, contract.getTotalMoney());
            preparedStatement.executeUpdate();
            Statement enableForeignKeyCheck = connection.createStatement();
            enableForeignKeyCheck.execute(ENABLE_FOREIGN_KEY_CHECK);
            enableForeignKeyCheck.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Contract> selectAllContracts() {
        Connection connection = baseRepository.connectDatabase();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");
                String madeDate = resultSet.getString("contract_made_date");
                String endDate = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("contract_deposit");
                double totalMoney = resultSet.getDouble("contract_total");
                Contract contract = new Contract(id, employeeId, customerId, serviceId, madeDate, endDate, deposit, totalMoney);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
