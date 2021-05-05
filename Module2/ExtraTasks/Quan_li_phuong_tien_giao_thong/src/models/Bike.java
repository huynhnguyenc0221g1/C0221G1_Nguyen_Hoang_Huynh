package models;

public class Bike extends Vehicle{
    private double horsePower;

    public Bike() {
    }

    public Bike(String numberPlate, String manufacturer, int yearProduced, String owner, double horsePower) {
        super(numberPlate, manufacturer, yearProduced, owner);
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "horsePower=" + horsePower +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
