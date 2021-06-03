package model.bean;

public class Contract {
    private int id;
    private String made_date;
    private String end_date;
    private double deposit;
    private double total_money;
    private int employee_id;
    private int customer_id;
    private int service_id;

    public Contract() {
    }

    public Contract(int id, String made_date, String end_date, double deposit, double total_money, int employee_id, int customer_id, int service_id) {
        this.id = id;
        this.made_date = made_date;
        this.end_date = end_date;
        this.deposit = deposit;
        this.total_money = total_money;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMade_date() {
        return made_date;
    }

    public void setMade_date(String made_date) {
        this.made_date = made_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
