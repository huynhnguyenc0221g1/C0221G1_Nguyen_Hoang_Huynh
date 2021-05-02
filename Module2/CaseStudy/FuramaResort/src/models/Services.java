package models;

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double areaUsage;
    protected double rentCost;
    protected int maxGuests;
    protected String rentType;

    public Services(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUsage = areaUsage;
        this.rentCost = rentCost;
        this.maxGuests = maxGuests;
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaUsage=" + areaUsage +
                ", rentCost=" + rentCost +
                ", maxGuests=" + maxGuests +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    public abstract void showInfo();
}
