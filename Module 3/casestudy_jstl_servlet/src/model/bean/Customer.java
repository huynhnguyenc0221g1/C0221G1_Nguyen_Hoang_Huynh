package model.bean;

public class Customer {
    private int id;
    private int type_id;
    private String name;
    private String birthdate;
    private byte gender;
    private String id_number;
    private String phone_number;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, int type_id, String name, String birthdate, byte gender, String id_number, String phone_number, String email, String address) {
        this.id = id;
        this.type_id = type_id;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.id_number = id_number;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
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

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
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
}
