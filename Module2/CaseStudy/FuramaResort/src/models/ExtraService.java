package models;

public class ExtraService {
    private String nameOfExtraService;
    private String unitOfExtraService;
    private double priceOfExtraService;

    public ExtraService(String nameOfExtraService, String unitOfExtraService, double priceOfExtraService) {
        this.nameOfExtraService = nameOfExtraService;
        this.unitOfExtraService = unitOfExtraService;
        this.priceOfExtraService = priceOfExtraService;
    }

    public String getNameOfExtraService() {
        return nameOfExtraService;
    }

    public void setNameOfExtraService(String nameOfExtraService) {
        this.nameOfExtraService = nameOfExtraService;
    }

    public String getUnitOfExtraService() {
        return unitOfExtraService;
    }

    public void setUnitOfExtraService(String unitOfExtraService) {
        this.unitOfExtraService = unitOfExtraService;
    }

    public double getPriceOfExtraService() {
        return priceOfExtraService;
    }

    public void setPriceOfExtraService(double priceOfExtraService) {
        this.priceOfExtraService = priceOfExtraService;
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "nameOfExtraService='" + nameOfExtraService + '\'' +
                ", unitOfExtraService='" + unitOfExtraService + '\'' +
                ", priceOfExtraService=" + priceOfExtraService +
                '}';
    }
}
