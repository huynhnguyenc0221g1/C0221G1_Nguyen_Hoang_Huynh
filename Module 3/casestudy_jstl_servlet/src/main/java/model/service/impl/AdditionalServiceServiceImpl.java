package model.service.impl;

import model.bean.AdditionalService;
import model.repository.AdditionalServiceRepository;
import model.service.IAdditionalServiceService;

public class AdditionalServiceServiceImpl implements IAdditionalServiceService {
    AdditionalServiceRepository additionalServiceRepository = new AdditionalServiceRepository();
    @Override
    public boolean updateAdditionalService(AdditionalService additionalService) {
        return additionalServiceRepository.updateAdditionalService(additionalService);
    }

    @Override
    public AdditionalService selectAdditionalService(int id) {
        return additionalServiceRepository.selectAdditionalService(id);
    }
}
