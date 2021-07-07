package com.codygym.model.dto;

import com.codygym.model.entity.employee.Division;
import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.entity.employee.Position;

import javax.validation.constraints.*;

public class EmployeeDto {
    private  Integer id;
    @NotNull(message = "Cannot input null!")
    @NotBlank
    private  String employeeName;
    @NotNull(message = "Cannot input null!")
    @NotBlank
    private  String employeeBirthday;
    @Pattern(regexp = "^[0-9]{10}", message = "Employee's ID Number must contains 10 digits")
    private String employeeIdCard;
    @NotNull(message = "Cannot input null!")
    @Min(value = 0,message = "Please input larger-than-0 value")
    private Double employeeSalary;
    @NotNull
    @Pattern(regexp = "^[0-9]{10}" , message = "Employee's Phone Number must contains 10 digits")
    private  String employeePhone;
    @NotBlank(message = "Please input email")
    @Email(message = "Invalid Email's format")
    private  String employeeEmail;
    @NotNull
    private String employeeAddress;
    private Division division;  private Position position;
    private EducationDegree educationDegree;

    public EmployeeDto(Integer id, String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail,
                       String employeeAddress, Division division, Position position, EducationDegree educationDegree) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.division = division;
        this.position = position;
        this.educationDegree = educationDegree;
    }

    public EmployeeDto(String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail,
                       String employeeAddress, Division division, Position position, EducationDegree educationDegree) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.division = division;
        this.position = position;
        this.educationDegree = educationDegree;
    }

    public EmployeeDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
