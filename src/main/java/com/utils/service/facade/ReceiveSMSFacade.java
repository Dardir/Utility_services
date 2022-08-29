package com.utils.service.facade;

import com.utils.service.camel.common.Constants;
import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.dto.sms.SendSMSRequestDTO;
import com.utils.service.service.ServiceCaller;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.utils.service.util.*;

@Component
public class ReceiveSMSFacade {

    private final ServiceCaller serviceCaller;
    private final ServiceResponseFacade serviceResponseFacade;
    private final Constants constants;

    public ReceiveSMSFacade(ServiceCaller serviceCaller, ServiceResponseFacade serviceResponseFacade, Environment env, Constants constants) {
        this.serviceCaller = serviceCaller;
        this.serviceResponseFacade = serviceResponseFacade;

        this.constants = constants;
    }

    public ServiceResponse processSMS(SendSMSRequestDTO sendSMSRequestDTO) {
        ServiceResponse serviceResponse = null;
        // Generated
        String msgId = System.currentTimeMillis() + "";
        ///////////////////////////////////////////////////////
        // From Request
        String mobileNumber = sendSMSRequestDTO.getMobileNumber();
        String body = sendSMSRequestDTO.getMsgBody();
        ///////////////////////////////////////////////////////
        // From Properties
        String sender =constants.getSMSSenderName();
        String userName = constants.getSendSMSUserName();
        String password = constants.getSendSMSPassword();
        String url = constants.getSendSMSBaseServiceURL();
        ///////////////////////////////////////////////////////
        if (!ObjectUtil.isNullOrEmpty(mobileNumber) && !ObjectUtil.isNullOrEmpty(body)) {
            if (ObjectUtil.onlyDigits(mobileNumber)) {
                String res = serviceCaller.sendRestRequest
                        (url + "?Msg_ID=" + msgId + "&Mobile_NO=" + mobileNumber +
                                        "&Body=" + body +
                                        "&Validty&StartTime&Sender=" + sender +
                                        "&User=" + userName + "&Password=" + password +
                                        "&Service=&Validty=&StartTime=",
                                String.class);
//                System.out.println("RES =========>>>>>>>>>>   " + res);
                if (!ObjectUtil.isNullOrEmpty(res)) {
                    if (ServiceResponseFacade.isSuccessResponseCode(res)) {
                        return serviceResponseFacade.generateSuccessResponse();
                    } else if (ServiceResponseFacade.isInternalErrorHappen(res)) {
                        serviceResponseFacade.generateInternalErrorResponse();
//                        serviceResponseFacade.generateSMSResponse
//                                (SMSResponseCodeDescriptionEnum.ERROR_FIRE.getErrorDescription(), SMSResponseCodesEnum.ERROR_FIRE_CODE.getErrorCode());
                    }
                } else {
                    return serviceResponseFacade.generateInternalErrorResponse();
                }
            } else {
                return serviceResponseFacade.generateInvalidMobileNumberResponse();
            }
        } else if (ObjectUtil.isNullOrEmpty(mobileNumber) || ObjectUtil.isNullOrEmpty(body)) {
            return serviceResponseFacade.generateMissingMandatoryFieldResponse();
        } else {
            serviceResponseFacade.generateInternalErrorResponse();
        }

        return null;
    }
}
