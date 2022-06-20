package com.utils.service.facade;

import com.utils.service.dto.sms.SendSMSRequestDTO;
import com.utils.service.service.ServiceCaller;
import org.springframework.stereotype.Component;

@Component
public class ReceiveSMSFacade {

    private final ServiceCaller serviceCaller;

    public ReceiveSMSFacade(ServiceCaller serviceCaller) {
        this.serviceCaller = serviceCaller;
    }

    public boolean processSMS(SendSMSRequestDTO sendSMSRequestDTO) {
        // Generated
        String msgId = System.currentTimeMillis() + "";
        ///////////////////////////////////////////////////////
        // From Request
//        String mobileNumber = "00201112376412";
//        String body = "Hello From the other side";
        String mobileNumber = sendSMSRequestDTO.getMobileNumber();
        String body = sendSMSRequestDTO.getMsgBody();
        ///////////////////////////////////////////////////////
        // From Properties
        String sender = "BARAKA EGY";
        String userName = "BARAKA Test";
        String password = "Bara@1234";
        String url = "https://www.ezagel.com/portex_ws/service.asmx/Send_SMS";
        ///////////////////////////////////////////////////////
        String res = serviceCaller.sendRestRequest
                (url + "?Msg_ID=" + msgId + "&Mobile_NO=" + mobileNumber +
                                "&Body=" + body +
                                "&Validty&StartTime&Sender=" + sender +
                                "&User=" + userName + "&Password=" + password +
                                "&Service=&Validty=&StartTime=",
                        String.class);
        System.out.println("RES =========>>>>>>>>>>   " + res);
        return res.contains("Success");
    }
}
