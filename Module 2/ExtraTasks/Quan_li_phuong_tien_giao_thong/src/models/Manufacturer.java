package models;

public class Manufacturer {
    private String idManufacturer;
    private String nameManufacturer;
    private String nationalityManufacturer;

    public Manufacturer() {
    }

    public Manufacturer(String idManufacturer, String nameManufacturer, String nationalityManufacturer) {
        this.idManufacturer = idManufacturer;
        this.nameManufacturer = nameManufacturer;
        this.nationalityManufacturer = nationalityManufacturer;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public String getNationalityManufacturer() {
        return nationalityManufacturer;
    }

    public void setNationalityManufacturer(String nationalityManufacturer) {
        this.nationalityManufacturer = nationalityManufacturer;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufacturer='" + idManufacturer + '\'' +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                ", nationalityManufacturer='" + nationalityManufacturer + '\'' +
                '}';
    }
}
