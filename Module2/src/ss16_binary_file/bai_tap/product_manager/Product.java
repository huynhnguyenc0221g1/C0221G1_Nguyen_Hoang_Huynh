package ss16_binary_file.bai_tap.product_manager;

import java.io.Serializable;

public class Product implements Serializable {
    private int productCode;
    private String productName;
    private String producer;
    private double price;
    private String description;

    public Product() {
    }

    public Product(int productCode, String productName, String producer, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.producer = producer;
        this.price = price;
        this.description = description;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
