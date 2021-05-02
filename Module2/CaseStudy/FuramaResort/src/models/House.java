package models;

public class House extends Services{
    private String standard;
    private String otherInfo;
    private int numberOfFloors;

    public House(){}
    public House(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType, String standard, String otherInfo, int numberOfFloors) {
        super(id, serviceName, areaUsage, rentCost, maxGuests, rentType);
        this.standard = standard;
        this.otherInfo = otherInfo;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
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
                ", otherDescription='" + otherInfo + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.format(this.toString());
    }
}
