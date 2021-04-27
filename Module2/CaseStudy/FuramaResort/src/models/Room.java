package models;

public class Room extends Services {
    private String roomFreeAmenities;

    public Room(String serviceName, double areaUsageService, double priceService, int maximumGuests, String rentOption, String id, String roomFreeAmenities) {
        super(serviceName, areaUsageService, priceService, maximumGuests, rentOption, id);
        this.roomFreeAmenities = roomFreeAmenities;
    }

    public String getRoomFreeAmenities() {
        return roomFreeAmenities;
    }

    public void setRoomFreeAmenities(String roomFreeAmenities) {
        this.roomFreeAmenities = roomFreeAmenities;
    }

    @Override
    public String showInfor() {
        return "Room{" +
                "roomFreeAmenities='" + roomFreeAmenities + '\'' +
                "} " + super.toString();
    }


}
