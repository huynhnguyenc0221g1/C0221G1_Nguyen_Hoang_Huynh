package models;

public abstract class Vehicle {
    protected String numberPlate;
    protected String manufacturer;
    protected int yearProduced;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(String numberPlate, String manufacturer, int yearProduced, String owner) {
        this.numberPlate = numberPlate;
        this.manufacturer = manufacturer;
        this.yearProduced = yearProduced;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(int yearProduced) {
        this.yearProduced = yearProduced;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "numberPlate='" + numberPlate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearProduced=" + yearProduced +
                ", owner='" + owner + '\'' +
                '}';
    }

    public abstract void showInfo();
}
