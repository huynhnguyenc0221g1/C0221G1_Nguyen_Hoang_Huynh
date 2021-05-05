package models;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String type;

    public Car() {
    }

    public Car(String numberPlate, String manufacturer, int yearProduced, String owner, int numberOfSeats, String type) {
        super(numberPlate, manufacturer, yearProduced, owner);
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
