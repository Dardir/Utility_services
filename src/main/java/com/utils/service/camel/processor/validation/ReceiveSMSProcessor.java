package com.utils.service.camel.processor.validation;

import com.google.gson.Gson;
import com.utils.service.dto.sms.SendSMSRequestDTO;
import com.utils.service.facade.ReceiveSMSFacade;
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

    public ReceiveSMSProcessor(ReceiveSMSFacade receiveSMSFacade) {
        this.receiveSMSFacade = receiveSMSFacade;
    }

    @Override
    public void process(Exchange exchange) {
        String request = exchange.getIn()
                .getBody(String.class);
        Gson gson = new Gson();
        SendSMSRequestDTO msg = gson.fromJson(request, SendSMSRequestDTO.class);
        System.out.println("MSG =========>>>>>>>>>>   " + msg);
        ///////////////////////////////////////////////////////
        boolean res = receiveSMSFacade.processSMS(msg);
        System.out.println("SENT? =========>>>>>>>>>>   " + res);


    }
}
