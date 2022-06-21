package com.utils.service.camel.processor.validation.common;

import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.facade.ServiceResponseFacade;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalExceptionProcessor implements Processor {
    private final ServiceResponseFacade serviceResponseFacade;

    public GlobalExceptionProcessor(ServiceResponseFacade serviceResponseFacade) {
        this.serviceResponseFacade = serviceResponseFacade;
    }

    @Override
    public void process(Exchange exchange) {
        ServiceResponse serviceResponse = serviceResponseFacade.handleGlobalException();
        Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
        exception.printStackTrace();
        exchange.getMessage().setBody(serviceResponse);
    }

}
