package models;

public class House extends Services{
    private String standard;
    private String otherDescription;
    private int numberOfFloors;

    public House(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType, String standard, String otherDescription, int numberOfFloors) {
        super(id, serviceName, areaUsage, rentCost, maxGuests, rentType);
        this.standard = standard;
        this.otherDescription = otherDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "standard='" + standard + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.format(this.toString());
    }
}
