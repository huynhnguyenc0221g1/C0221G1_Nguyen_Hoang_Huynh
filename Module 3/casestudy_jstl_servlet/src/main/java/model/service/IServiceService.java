package model.service;

import model.bean.RentOption;
import model.bean.Service;
import model.bean.ServiceType;

import java.util.List;

public interface IServiceService {
    public void insertService(Service service);
    public List<Service> selectAllService();
    public boolean updateService(Service service);
    public Service selectServiceById(int id);
    public List<ServiceType> selectAllServiceTypes();
    public List<RentOption> selectAllRentOption();
}
