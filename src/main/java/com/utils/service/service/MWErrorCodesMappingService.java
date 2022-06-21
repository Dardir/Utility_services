package com.utils.service.service;


import com.utils.service.entity.MWErrorCodesMapping;
import com.utils.service.repository.MWErrorCodesMappingRepo;
import org.springframework.stereotype.Service;

@Service
public class MWErrorCodesMappingService {
    private final MWErrorCodesMappingRepo mwErrorCodesMappingRepo;


    public MWErrorCodesMappingService(MWErrorCodesMappingRepo mwErrorCodesMappingRepo) {
        this.mwErrorCodesMappingRepo = mwErrorCodesMappingRepo;
    }
    public MWErrorCodesMapping findByBeNameAndAndBeErrorCode(String beName, String beErrorCode){
        return mwErrorCodesMappingRepo.findByBeNameAndAndBeErrorCode(beName,beErrorCode);
    }
}
