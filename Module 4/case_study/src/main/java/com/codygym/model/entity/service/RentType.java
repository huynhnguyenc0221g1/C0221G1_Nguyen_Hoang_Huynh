package com.codygym.model.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private String rentTypeName;
    private double rentTypeCost;
    @OneToMany(targetEntity = Service.class)
    List<Service> services;

    public RentType() {
    }

    public RentType(String rentTypeName, double rentTypeCost, List<Service> services) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public RentType(Integer id, String rentTypeName, double rentTypeCost, List<Service> services) {
        this.id = id;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}