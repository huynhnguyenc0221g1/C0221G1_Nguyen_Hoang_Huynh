package model.bean;

public class Service {
    private int id;
    private String code;
    private String name;
    private int area;
    private double cost;
    private int maxInHouse;
    private int rentTypeId;
    private int serviceTypeId;
    private String standard;
    private String description;
    private Double poolArea;
    private int numberOfFloors;

    public Service() {
    }

    public Service(int id, String code, String name, int area, double cost, int maxInHouse, int rentTypeId, int serviceTypeId, String standard, String description, Double poolArea, int numberOfFloors) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxInHouse = maxInHouse;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxInHouse() {
        return maxInHouse;
    }

    public void setMaxInHouse(int maxInHouse) {
        this.maxInHouse = maxInHouse;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
