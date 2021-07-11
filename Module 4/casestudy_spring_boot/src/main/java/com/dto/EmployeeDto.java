package com.dto;

import com.model.entity.employee.Division;
import com.model.entity.employee.Education;
import com.model.entity.employee.Position;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class EmployeeDto implements Validator {
    private Long employeeId;
    @NotBlank(message = "Must not be blank!")
    private String name;
    @NotBlank(message = "Must not be blank!")
    private String birthday;
    @NotBlank(message = "Must not be blank!")
    private String idCard;
    @NotBlank(message = "Must not be blank!")
    private String salary;
    @NotBlank(message = "Must not be blank!")
    private String phone;
    @Email(message = "Invalid Email Format!")
    private String email;
    private String address;

    private Position position;
    private Division division;
    private Education education;
    private boolean flag = true;

    public EmployeeDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
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
        EmployeeDto employeeDto = (EmployeeDto) target;

        if (!employeeDto.phone.matches("^(090|091)[0-9]{7}$")) {
            errors.rejectValue("phone", "employee.validPhone", "Employee's Phone must have the format: 091xxxxxxx or 090xxxxxxx");
        }
        if (!employeeDto.idCard.matches("^[0-9]{9,10}$")) {
            errors.rejectValue("idCard", "employee.validIdCard", "Employee's ID Card must contain 10 digits");
        }
        if (!employeeDto.salary.matches("^[0-9]+$")) {
            errors.rejectValue("salary", "employee.validSalary", "Must input number!");
        } else if (Integer.parseInt(employeeDto.salary) < 0) {
            errors.rejectValue("salary", "employee.validSalary", "Employee's salary must be greater than 0");
        }
    }
}
