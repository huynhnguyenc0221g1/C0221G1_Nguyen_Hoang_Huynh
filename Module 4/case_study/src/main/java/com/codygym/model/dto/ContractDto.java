package com.codygym.model.dto;

import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.service.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ContractDto {
    private  Integer id;
    @NotNull
    private  String contractStartDay;
    @NotNull
    private  String contractEndDay;
    @NotNull(message = "Cannot input null!")
    @Min(value = 0,message = "Please input larger-than-0 value")
    private double contractDeposit;
    @NotNull(message = "Cannot input null!")
    @Min(value = 0,message = "Please input larger-than-0 value")
    private double contractTotal;

    private List<ContractDetail> contractDetails;

    private Service service;

    private Employee employee;

    private Customer customer;

    public ContractDto() {
    }

    public ContractDto(Integer id, String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal, List<ContractDetail> contractDetails,
                       Service service, Employee employee, Customer customer) {
        this.id = id;
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
        this.contractDetails = contractDetails;
        this.service = service;
        this.employee = employee;
        this.customer = customer;
    }

    public ContractDto(String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal, List<ContractDetail> contractDetails,
                       Service service, Employee employee, Customer customer) {
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
        this.contractDetails = contractDetails;
        this.service = service;
        this.employee = employee;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(double contractTotal) {
        this.contractTotal = contractTotal;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
