package com.utils.service.dto.sms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utils.service.entity.MWErrorCodesMapping;
import com.utils.service.enums.BENamesEnum;
import com.utils.service.enums.MWDefaultStatusCodeEnum;
import com.utils.service.enums.SMSResponseCodeDescriptionEnum;
import com.utils.service.enums.SMSResponseCodesEnum;
import com.utils.service.facade.MWErrorCodesMappingFacade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ServiceResponse {

    private ServiceHeader serviceHeader;
    private Object responseBody;

    @Autowired
    @JsonIgnore
    private MWErrorCodesMappingFacade mwErrorCodesMappingFacade;


    public ServiceResponse(MWErrorCodesMappingFacade mwErrorCodesMappingFacade) {
        this.mwErrorCodesMappingFacade = mwErrorCodesMappingFacade;
    }

    public void generateSuccessResponse() {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateSuccessCode();
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(),codeMapping.getMwErrorDesc()));
//        this.setServiceHeader(new ServiceHeader(SMSResponseCodesEnum.SUCCESS_CODE.getErrorCode(), SMSResponseCodeDescriptionEnum.SUCCESS.getErrorDescription()));
    }

    public void generateFailureResponse(BENamesEnum beName, String beErrorCode) {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateFailureCode(beName, beErrorCode);
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(), codeMapping.getMwErrorDesc()));
    }

    public void generateGeneralFailureResponse() {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateGeneralFailureCode();
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(), codeMapping.getMwErrorDesc()));
    }

    public Object setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public void generateInternalErrorResponse() {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateFailureCode(BENamesEnum.EZAGEL, MWDefaultStatusCodeEnum.GENERAL_ERROR.getCode());
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(),codeMapping.getMwErrorDesc()));
//        this.setServiceHeader(new ServiceHeader(SMSResponseCodesEnum.ERROR_FIRE_CODE.getErrorCode(), SMSResponseCodeDescriptionEnum.ERROR_FIRE.getErrorDescription()));

    }
    public void generateInvalidMobileNumberResponse() {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateFailureCode(BENamesEnum.EZAGEL, MWDefaultStatusCodeEnum.INVALID_MOBILE_NUMBER.getCode());
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(),codeMapping.getMwErrorDesc()));
//
//        this.setServiceHeader(new ServiceHeader(SMSResponseCodesEnum.INVALID_MOBILE_CODE.getErrorCode(), SMSResponseCodeDescriptionEnum.INVALID_MOBILE.getErrorDescription()));

    }
    public void generateMissingMandatoryFieldResponse() {
        MWErrorCodesMapping codeMapping = mwErrorCodesMappingFacade.generateFailureCode(BENamesEnum.EZAGEL, MWDefaultStatusCodeEnum.EMPTY_BODY_OR_MOBILE_NO.getCode());
        this.setServiceHeader(new ServiceHeader(codeMapping.getMwErrorCode(),codeMapping.getMwErrorDesc()));
//
//        this.setServiceHeader(new ServiceHeader(SMSResponseCodesEnum.INVALID_MOBILE_CODE.getErrorCode(), SMSResponseCodeDescriptionEnum.INVALID_MOBILE.getErrorDescription()));

    }
}
