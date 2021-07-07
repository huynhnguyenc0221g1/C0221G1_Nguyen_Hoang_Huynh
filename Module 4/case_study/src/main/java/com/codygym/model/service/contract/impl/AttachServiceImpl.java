package com.codygym.model.service.contract.impl;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.repository.contract.IAttachServiceRepository;
import com.codygym.model.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachServiceImpl  implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;
    @Override
    public Iterable<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return iAttachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        iAttachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        iAttachServiceRepository.deleteById(id);
    }
}