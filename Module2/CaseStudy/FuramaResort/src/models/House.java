package models;

public class House extends Services{
    private String houseRoomStandard;
    private String houseOtherAmenities;
    private int houseNumberOfFloors;

    public House(String serviceName, double areaUsageService, double priceService, int maximumGuests, String rentOption, String id, String houseRoomStandard, String houseOtherAmenities, int houseNumberOfFloors) {
        super(serviceName, areaUsageService, priceService, maximumGuests, rentOption, id);
        this.houseRoomStandard = houseRoomStandard;
        this.houseOtherAmenities = houseOtherAmenities;
        this.houseNumberOfFloors = houseNumberOfFloors;
    }

    public String getHouseRoomStandard() {
        return houseRoomStandard;
    }

    public void setHouseRoomStandard(String houseRoomStandard) {
        this.houseRoomStandard = houseRoomStandard;
    }

    public String getHouseOtherAmenities() {
        return houseOtherAmenities;
    }

    public void setHouseOtherAmenities(String houseOtherAmenities) {
        this.houseOtherAmenities = houseOtherAmenities;
    }

    public int getHouseNumberOfFloors() {
        return houseNumberOfFloors;
    }

    public void setHouseNumberOfFloors(int houseNumberOfFloors) {
        this.houseNumberOfFloors = houseNumberOfFloors;
    }

    @Override
    public String toString() {
        return  super.toString() + houseRoomStandard + "," +
                houseOtherAmenities + "," +
                houseNumberOfFloors + ",";
    }

    @Override
    public String showInfor() {
        return "House ID :" + super.getId() + "\n[ House's Room Standard: " + houseRoomStandard + "\n" +
                "House's Other Amenities: " + houseOtherAmenities + "\n" +
                "Number Of Floors: " + houseNumberOfFloors +" ]\n";
    }
}
