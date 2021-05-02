package models;

public class Villa extends Services{
    private String standard;
    private String otherInfo;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType, String standard, String otherInfo, double poolArea, int numberOfFloors) {
        super(id, serviceName, areaUsage, rentCost, maxGuests, rentType);
        this.standard = standard;
        this.otherInfo = otherInfo;
        this.poolArea = poolArea;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "villaStandard='" + standard + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
