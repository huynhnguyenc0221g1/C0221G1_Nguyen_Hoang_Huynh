package model.bean;

public class ContractDetail {
    private int id;
    private int contract_id;
    private int attach_service_id;
    private int amount;

    public ContractDetail() {
    }

    public ContractDetail(int id, int contract_id, int attach_service_id, int amount) {
        this.id = id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
