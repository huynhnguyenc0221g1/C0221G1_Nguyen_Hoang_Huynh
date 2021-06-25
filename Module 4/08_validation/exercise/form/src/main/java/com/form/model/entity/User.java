package com.form.model.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}" , message = "Phone number must contain 10 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{2,}" , message =  "Age must be above 18")
    @Range(min = 18, max = 100)
    private String age;

    @NotEmpty
    @Pattern(regexp =  "^(.+)@(.+)$", message = "Invalid Email Format")
    private  String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(Integer id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
