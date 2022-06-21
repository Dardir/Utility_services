package com.utils.service.camel.processor.validation.common;

import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.facade.ServiceResponseFacade;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GenerateServiceResponseProcessor implements Processor {

    private final ServiceResponseFacade serviceResponseFacade;

    public GenerateServiceResponseProcessor(ServiceResponseFacade serviceResponseFacade) {
        this.serviceResponseFacade = serviceResponseFacade;
    }

    @Override
    public void process(Exchange exchange) {
        ServiceResponse response = exchange.getMessage().getBody(ServiceResponse.class);
        // response.setRespCode();// from database by sending response.getMwErrorCode() to the database table

        exchange.getMessage().setBody(response);
    }

}
