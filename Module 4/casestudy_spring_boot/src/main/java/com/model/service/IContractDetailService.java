package com.model.service;

import com.model.entity.contractDetail.AttachService;
import com.model.entity.contractDetail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService extends IGenerateService<ContractDetail> {
    Page<ContractDetail> findByContractId(Long id, Pageable pageable);
    List<AttachService> listAttachService();
}
