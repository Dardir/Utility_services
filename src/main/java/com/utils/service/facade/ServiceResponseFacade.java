package com.utils.service.facade;


import com.utils.service.camel.common.FlowRouteNames;
import com.utils.service.dto.sms.ServiceHeader;
import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.enums.SMSResponseCodeDescriptionEnum;
import com.utils.service.enums.SMSResponseCodesEnum;
import com.utils.service.enums.SMSServiceStatusEnum;
import com.utils.service.dto.sms.SMSResponseWrapperDTO;
import com.utils.service.dto.sms.SendSMSResponseDTO;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseFacade {

    private final ProducerTemplate template;
    private final MWErrorCodesMappingFacade mwErrorCodesMappingFacade;

    public ServiceResponseFacade(ProducerTemplate template, MWErrorCodesMappingFacade mwErrorCodesMappingFacade) {
        this.template = template;
        this.mwErrorCodesMappingFacade = mwErrorCodesMappingFacade;
    }

    public static boolean isSuccessResponseCode(String response) {
        return response.contains(SMSServiceStatusEnum.SUCCESS.getErrorDescription());
    }

    public static boolean isInternalErrorHappen(String response) {
        return response.contains(SMSServiceStatusEnum.ERROR_FIRE.getErrorDescription());
    }

    public SMSResponseWrapperDTO generateSMSResponse(String responseStatus, String responseCode) {
        SMSResponseWrapperDTO smsResponseWrapperDTO = new SMSResponseWrapperDTO();
        SendSMSResponseDTO sendSMSResponseDTO = new SendSMSResponseDTO();
        sendSMSResponseDTO.setResponseCode(responseCode);
        sendSMSResponseDTO.setResponseDescription(responseStatus);
        smsResponseWrapperDTO.setSendSMSResponseDTO(sendSMSResponseDTO);
        return smsResponseWrapperDTO;
    }

    public void prepareServiceResponseRedirection(Object response, Exchange exchange) {
        this.prepareInternalRouteRedirection(response, exchange, FlowRouteNames.GENERATE_SERVICE_RESPONSE_ROUTE_NAME);
    }

    public void prepareInternalRouteRedirection(Object object, Exchange exchange, String flowName) {
        exchange.getMessage().setBody(object);
        template.send(flowName, exchange);
    }

    public ServiceResponse handleGlobalException() {
        ServiceResponse serviceResponse;
        try {
            serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
            serviceResponse.generateGeneralFailureResponse();
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse = new ServiceResponse();
            serviceResponse.generateGeneralFailureResponse();
        }
//        exchange.getMessage().setBody(serviceResponse);
        return serviceResponse;
    }

    public ServiceResponse generateGeneralFailureResponse() {
        ServiceResponse serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
        serviceResponse.generateGeneralFailureResponse();
        return serviceResponse;
    }

    public ServiceResponse generateSuccessResponse() {
        ServiceResponse serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
        serviceResponse.generateSuccessResponse();
        return serviceResponse;
    }

    public ServiceResponse generateInternalErrorResponse() {
        ServiceResponse serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
        serviceResponse.generateInternalErrorResponse();
        return serviceResponse;
    }

    public ServiceResponse generateInvalidMobileNumberResponse() {
        ServiceResponse serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
        serviceResponse.generateInvalidMobileNumberResponse();
        return serviceResponse;
    }
    public ServiceResponse generateMissingMandatoryFieldResponse() {
        ServiceResponse serviceResponse = new ServiceResponse(mwErrorCodesMappingFacade);
        serviceResponse.generateMissingMandatoryFieldResponse();
        return serviceResponse;
    }
}
