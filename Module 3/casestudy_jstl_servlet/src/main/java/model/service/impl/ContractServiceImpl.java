package model.service.impl;

import model.bean.Contract;
import model.repository.ContractRepository;
import model.service.IContractService;

public class ContractServiceImpl implements IContractService {
    ContractRepository contractRepository = new ContractRepository();
    @Override
    public void insertContract(Contract contract) {
        contractRepository.insertContract(contract);
    }
}
