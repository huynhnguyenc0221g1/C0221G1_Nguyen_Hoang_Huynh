package models;

public class Villa extends Services{
    private String villaRoomStandard;
    private String villaOtherAmenities;
    private double villaPoolArea;
    private int villaNumberOfFloors;

    public Villa(String serviceName, double areaUsageService, double priceService, int maximumGuests, String rentOption, String id, String villaRoomStandard, String villaOtherAmenities, double villaPoolArea, int villaNumberOfFloors) {
        super(serviceName,areaUsageService,priceService,maximumGuests,rentOption,id);
        this.villaRoomStandard = villaRoomStandard;
        this.villaOtherAmenities = villaOtherAmenities;
        this.villaPoolArea = villaPoolArea;
        this.villaNumberOfFloors = villaNumberOfFloors;
    }

    public String getVillaRoomStandard() {
        return villaRoomStandard;
    }

    public void setVillaRoomStandard(String villaRoomStandard) {
        this.villaRoomStandard = villaRoomStandard;
    }

    public String getVillaOtherAmenities() {
        return villaOtherAmenities;
    }

    public void setVillaOtherAmenities(String villaOtherAmenities) {
        this.villaOtherAmenities = villaOtherAmenities;
    }

    public double getVillaPoolArea() {
        return villaPoolArea;
    }

    public void setVillaPoolArea(double villaPoolArea) {
        this.villaPoolArea = villaPoolArea;
    }

    public int getVillaNumberOfFloors() {
        return villaNumberOfFloors;
    }

    public void setVillaNumberOfFloors(int villaNumberOfFloors) {
        this.villaNumberOfFloors = villaNumberOfFloors;
    }


    @Override
    public String toString() {
        return super.toString() + villaRoomStandard + ","
                + villaOtherAmenities + ","
                + villaPoolArea + ","
                + villaNumberOfFloors;
    }

    @Override
    public String showInfor() {
        return "Villa ID :" + super.getId() + "\n[ Villa's Room Standard: " + villaRoomStandard + "\n"
              + "Villa's Other Amenities: "  + villaOtherAmenities + "\n"
               + "Villa's Pool Area: " + villaPoolArea + "\n"
               + "Number Of Floors: " + villaNumberOfFloors +" ]\n";
    }
}
