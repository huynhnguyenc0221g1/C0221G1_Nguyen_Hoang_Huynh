package models;

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double areaUsage;
    protected double rentCost;
    protected int maxGuests;
    protected String rentType;

    public Services(){}
    public Services(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUsage = areaUsage;
        this.rentCost = rentCost;
        this.maxGuests = maxGuests;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUsage() {
        return areaUsage;
    }

    public void setAreaUsage(double areaUsage) {
        this.areaUsage = areaUsage;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
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
