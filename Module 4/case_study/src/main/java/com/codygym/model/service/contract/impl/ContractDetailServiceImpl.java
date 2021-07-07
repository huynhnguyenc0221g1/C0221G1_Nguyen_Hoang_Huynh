package com.codygym.model.service.contract.impl;

import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.repository.contract.IContractDetailRepository;
import com.codygym.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {
        contractDetailRepository.deleteById(id);
    }
}
