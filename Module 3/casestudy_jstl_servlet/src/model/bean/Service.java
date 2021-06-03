package model.bean;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int max_in_house;
    private int rent_type_id;
    private int service_type_id;
    private String standard;
    private String description;
    private Double pool_area;
    private int number_of_floors;

    public Service() {
    }

    public Service(int id, String name, int area, double cost, int max_in_house, int rent_type_id, int service_type_id, String standard, String description, Double pool_area, int number_of_floors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_in_house = max_in_house;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard = standard;
        this.description = description;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
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

    public int getMax_in_house() {
        return max_in_house;
    }

    public void setMax_in_house(int max_in_house) {
        this.max_in_house = max_in_house;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
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

    public Double getPool_area() {
        return pool_area;
    }

    public void setPool_area(Double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
