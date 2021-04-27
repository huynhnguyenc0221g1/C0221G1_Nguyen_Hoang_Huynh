package models;

public abstract class Services {
    private String serviceName;
    private double areaUsageService;
    private double priceService;
    private int maximumGuests;
    private String rentOption;
    private String id;

    public Services(String serviceName, double areaUsageService, double priceService, int maximumGuests, String rentOption, String id) {
        this.serviceName = serviceName;
        this.areaUsageService = areaUsageService;
        this.priceService = priceService;
        this.maximumGuests = maximumGuests;
        this.rentOption = rentOption;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceName='" + serviceName + '\'' +
                ", areaUsageService=" + areaUsageService +
                ", priceService=" + priceService +
                ", maximumGuests=" + maximumGuests +
                ", rentOption='" + rentOption + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public abstract String showInfor();
}
