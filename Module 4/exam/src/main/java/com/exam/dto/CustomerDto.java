package com.exam.dto;

import com.exam.model.entity.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Long customerId;
    @NotBlank(message = "Must not be blank!")
    private String customerCode;
    @NotBlank(message = "Must not be blank!")
    private String customerName;
    @NotBlank(message = "Must not be blank!")
    private String customerBirthday;
    @NotBlank(message = "Must not be blank!")
    private String customerGender;
    @NotBlank(message = "Must not be blank!")
    private String customerIdCard;
    @NotBlank(message = "Must not be blank!")
    private String customerPhone;
    @Email(message = "Invalid Email Format!")
    private String customerEmail;

    private String customerAddress;
    private CustomerType customerType;
    private boolean flag = true;

    public CustomerDto() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.customerCode.matches("^KH-[0-9]{4}$")) {
            errors.rejectValue("customerCode", "customer.validCode", "Customer's code must have the format: KH-XXXX");
        }
        if (!customerDto.customerPhone.matches("^[0-9]{10}$")) {
            errors.rejectValue("customerPhone", "customer.validPhone", "Customer's phone must contain 10 digits");
        }
        if (!customerDto.customerIdCard.matches("^[0-9]{10}$")) {
            errors.rejectValue("customerIdCard", "customer.validIdcard", "Customer ID Card must contain 10 digits");
        }
    }
}
