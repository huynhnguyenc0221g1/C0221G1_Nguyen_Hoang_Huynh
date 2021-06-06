package model.service;

import model.bean.AdditionalService;
import model.bean.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    public void insertContractDetail(ContractDetail contractDetail);
    public List<AdditionalService> selectAllAdditionalServices();
}
