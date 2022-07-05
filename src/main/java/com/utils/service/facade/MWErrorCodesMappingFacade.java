package com.utils.service.facade;


import com.utils.service.entity.MWErrorCodesMapping;
import com.utils.service.enums.BENamesEnum;
import com.utils.service.enums.MWDefaultStatusCodeEnum;
import com.utils.service.service.MWErrorCodesMappingService;
import org.springframework.stereotype.Component;

@Component
public class MWErrorCodesMappingFacade {
    private final MWErrorCodesMappingService mwErrorCodesMappingService;

    public MWErrorCodesMappingFacade(MWErrorCodesMappingService mwErrorCodesMappingService) {
        this.mwErrorCodesMappingService = mwErrorCodesMappingService;
    }

    public MWErrorCodesMapping generateSuccessCode() {
        return this.mwErrorCodesMappingService.findByBeNameAndAndBeErrorCode(BENamesEnum.MW.getBeName(), MWDefaultStatusCodeEnum.SUCCESS.getCode());
    }


    public MWErrorCodesMapping generateFailureCode(BENamesEnum beName, String beErrorCode) {
        return this.mwErrorCodesMappingService.findByBeNameAndAndBeErrorCode(beName.getBeName(), beErrorCode);
    }

    public MWErrorCodesMapping generateGeneralFailureCode() {
        return this.mwErrorCodesMappingService.findByBeNameAndAndBeErrorCode(BENamesEnum.MW.getBeName(), MWDefaultStatusCodeEnum.GENERAL_ERROR.getCode());
    }
}
