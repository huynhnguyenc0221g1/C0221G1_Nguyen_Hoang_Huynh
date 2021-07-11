package com.model.service;

import com.model.entity.service.RentType;
import com.model.entity.service.Service;
import com.model.entity.service.ServiceType;

import java.util.List;

public interface IService extends IGenerateService<Service> {
    List<RentType> listRentType();
    List<ServiceType> listServiceType();
}
