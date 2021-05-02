package models;

public class Customer implements Comparable<Customer>{
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String typeOfCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String typeOfCustomer, String address, Services services) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.services = services;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }

    public void showInfo() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Customer secondCustomer) {
        int comparison = this.fullName.compareTo(secondCustomer.fullName);
        if (comparison == 0) {
            int firstCustomerBirthYear = Integer.parseInt((this.dateOfBirth.split("/")[2]));
            int secondCustomerBirthYear = Integer.parseInt((secondCustomer.dateOfBirth.split("/")[2]));
            comparison = firstCustomerBirthYear - secondCustomerBirthYear;
        }
        return comparison;
    }
}
