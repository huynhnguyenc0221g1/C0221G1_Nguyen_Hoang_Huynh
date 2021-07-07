package com.codygym.model.entity.contract;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.service.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String contractStartDay;
    private  String contractEndDay;
    private double contractDeposit;
    private double contractTotal;
    @OneToMany(targetEntity = ContractDetail.class)
    private List<ContractDetail> contractDetails;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Contract() {
    }

    public Contract(Integer id, String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal,
                    List<ContractDetail> contractDetails, Service service, Employee employee, Customer customer) {
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

    public Contract(String contractStartDay, String contractEndDay, double contractDeposit, double contractTotal,
                    List<ContractDetail> contractDetails, Service service, Employee employee, Customer customer) {
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