package model.bean;

public class Employee {
    private int id;
    private String name;
    private String birthdate;
    private String id_number;
    private double salary;
    private String phone_number;
    private String email;
    private String address;
    private int position_id;
    private int qualification_id;
    private int department_id;
    private String username;

    public Employee() {
    }

    public Employee(int id, String name, String birthdate, String id_number, double salary, String phone_number, String email, String address, int position_id, int qualification_id, int department_id, String username) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.id_number = id_number;
        this.salary = salary;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.position_id = position_id;
        this.qualification_id = qualification_id;
        this.department_id = department_id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(int qualification_id) {
        this.qualification_id = qualification_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
