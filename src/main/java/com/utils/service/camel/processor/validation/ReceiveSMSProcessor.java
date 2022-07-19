package com.utils.service.camel.processor.validation;

import com.utils.service.dto.sms.SMSResponseWrapperDTO;
import com.utils.service.dto.sms.SendSMSRequestDTO;
import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.facade.ReceiveSMSFacade;
import com.utils.service.facade.ServiceResponseFacade;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReceiveSMSProcessor implements Processor {

    private final ReceiveSMSFacade receiveSMSFacade;
    private final ServiceResponseFacade serviceResponseFacade;

    public ReceiveSMSProcessor(ReceiveSMSFacade receiveSMSFacade, ServiceResponseFacade serviceResponseFacade) {
        this.receiveSMSFacade = receiveSMSFacade;
        this.serviceResponseFacade = serviceResponseFacade;
    }

    @Override
    public void process(Exchange exchange) {
        SendSMSRequestDTO msg = exchange.getIn()
                .getBody(SendSMSRequestDTO.class);
//        System.out.println("MSG =========>>>>>>>>>>   " + msg);
//        ///////////////////////////////////////////////////////
        ServiceResponse res = receiveSMSFacade.processSMS(msg);
//        System.out.println("Description =========>>>>>>>>>>   " + res.getServiceHeader().getResponseDesc());
//        System.out.println("Code =========>>>>>>>>>>   " + res.getServiceHeader().getResponseCode());
        serviceResponseFacade.prepareServiceResponseRedirection(res, exchange);
    }
}
