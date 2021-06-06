package model.service;

import model.bean.AdditionalService;

public interface IAdditionalServiceService {
    public boolean updateAdditionalService(AdditionalService additionalService);
    public AdditionalService selectAdditionalService(int id);
}
