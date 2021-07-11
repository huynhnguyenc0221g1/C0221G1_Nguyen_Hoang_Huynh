package com.model.service.impl;

import com.model.entity.contractDetail.AttachService;
import com.model.entity.contractDetail.ContractDetail;
import com.model.repository.contractDetail.IAttachServiceRepository;
import com.model.repository.contractDetail.IContractDetailRepository;
import com.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public Page<ContractDetail> findAll(String keyWord, Pageable pageable) {
        return null;
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
        this.contractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> findByContractId(Long id,Pageable pageable) {
        return contractDetailRepository.findAllByContractId(id,pageable);
    }

    @Override
    public List<AttachService> listAttachService() {
        return attachServiceRepository.findAll();
    }
}
