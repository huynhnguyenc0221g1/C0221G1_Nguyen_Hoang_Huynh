package com.model.service;

import com.model.entity.contract.Contract;

import java.util.List;

public interface IContractService extends IGenerateService<Contract> {
    Iterable<Contract> fillAll();
}
