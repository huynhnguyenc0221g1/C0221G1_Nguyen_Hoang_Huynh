package model.bean;

public class ContractDetail {
    private int id;
    private int contractId;
    private int additionalServiceId;
    private int amount;

    public ContractDetail() {
    }

    public ContractDetail(int id, int contractId, int additionalServiceId, int amount) {
        this.id = id;
        this.contractId = contractId;
        this.additionalServiceId = additionalServiceId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAdditionalServiceId() {
        return additionalServiceId;
    }

    public void setAdditionalServiceId(int additionalServiceId) {
        this.additionalServiceId = additionalServiceId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
