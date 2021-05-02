package models;

public class Room extends Services{
    private ExtraService extraService;

    public Room(String id, String serviceName, double areaUsage, double rentCost, int maxGuests, String rentType, ExtraService extraService) {
        super(id, serviceName, areaUsage, rentCost, maxGuests, rentType);
        this.extraService = extraService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "extraService=" + extraService +
                "} " + super.toString();
    }

    @Override
    public void showInfo() {

    }
}
