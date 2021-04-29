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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUsageService() {
        return areaUsageService;
    }

    public void setAreaUsageService(double areaUsageService) {
        this.areaUsageService = areaUsageService;
    }

    public double getPriceService() {
        return priceService;
    }

    public void setPriceService(double priceService) {
        this.priceService = priceService;
    }

    public int getMaximumGuests() {
        return maximumGuests;
    }

    public void setMaximumGuests(int maximumGuests) {
        this.maximumGuests = maximumGuests;
    }

    public String getRentOption() {
        return rentOption;
    }

    public void setRentOption(String rentOption) {
        this.rentOption = rentOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return serviceName + "," +
                +areaUsageService + ","
                + priceService + ","
                + maximumGuests + ","
                + rentOption + ","
                + id + ",";
    }

    public abstract String showInfor();
}
