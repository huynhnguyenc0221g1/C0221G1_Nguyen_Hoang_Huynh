package model.bean;

public class CustomerWithServices {
   private int customerId;
   private String customerName;
   private int contractId;
   private String contractMadeDate;
   private String contractEndDate;
   private int contractDetailId;
   private int additionalServiceId;
   private String additionalServiceName;

    public CustomerWithServices() {
    }

    public CustomerWithServices(int customerId, String customerName, int contractId, String contractMadeDate, String contractEndDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.contractMadeDate = contractMadeDate;
        this.contractEndDate = contractEndDate;
    }

    public CustomerWithServices(int customerId, String customerName, int contractId, String contractMadeDate, String contractEndDate, int contractDetailId, int additionalServiceId, String additionalServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.contractMadeDate = contractMadeDate;
        this.contractEndDate = contractEndDate;
        this.contractDetailId = contractDetailId;
        this.additionalServiceId = additionalServiceId;
        this.additionalServiceName = additionalServiceName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractMadeDate() {
        return contractMadeDate;
    }

    public void setContractMadeDate(String contractMadeDate) {
        this.contractMadeDate = contractMadeDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getAdditionalServiceId() {
        return additionalServiceId;
    }

    public void setAdditionalServiceId(int additionalServiceId) {
        this.additionalServiceId = additionalServiceId;
    }

    public String getAdditionalServiceName() {
        return additionalServiceName;
    }

    public void setAdditionalServiceName(String additionalServiceName) {
        this.additionalServiceName = additionalServiceName;
    }
}
