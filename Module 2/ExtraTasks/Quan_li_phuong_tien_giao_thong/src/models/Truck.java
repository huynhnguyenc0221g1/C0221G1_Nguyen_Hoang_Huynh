package models;

public class Truck extends Vehicle{
    private double loadAmount;

    public Truck() {
    }

    public Truck(String numberPlate, String manufacturer, int yearProduced, String owner, double loadAmount) {
        super(numberPlate, manufacturer, yearProduced, owner);
        this.loadAmount = loadAmount;
    }

    public double getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(double loadAmount) {
        this.loadAmount = loadAmount;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadAmount=" + loadAmount +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
