package model.service.impl;

import model.bean.AdditionalService;
import model.bean.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.IContractDetailService;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.insertContractDetail(contractDetail);
    }

    @Override
    public List<AdditionalService> selectAllAdditionalServices() {
        return contractDetailRepository.selectAllAdditionalServices();
    }
}
