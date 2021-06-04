package model.service;

import model.bean.Service;

import java.util.List;

public interface IServiceService {
    public void insertService(Service service);
    public List<Service> selectAllService();
}
