package com.codygym.model.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String serviceTypeName;

    @OneToMany(targetEntity = Service.class)
    List<Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer id, String serviceTypeName, List<Service> services) {
        this.id = id;
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public ServiceType(String serviceTypeName, List<Service> services) {
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}