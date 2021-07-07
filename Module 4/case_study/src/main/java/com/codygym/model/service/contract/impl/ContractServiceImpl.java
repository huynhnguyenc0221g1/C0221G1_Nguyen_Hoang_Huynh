package com.codygym.model.service.contract.impl;

import com.codygym.model.entity.contract.Contract;
import com.codygym.model.repository.contract.IContractRepository;
import com.codygym.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }
}