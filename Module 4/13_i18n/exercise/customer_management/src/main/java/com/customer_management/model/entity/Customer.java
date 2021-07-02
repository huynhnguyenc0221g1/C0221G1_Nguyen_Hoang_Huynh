package com.customer_management.model.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id",referencedColumnName = "id")
    private Province customerProvince;

    public Customer() {
    }

    public Customer(Integer id, String name, Province customerProvince) {
        this.id = id;
        this.name = name;
        this.customerProvince = customerProvince;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(Province customerProvince) {
        this.customerProvince = customerProvince;
    }
}
