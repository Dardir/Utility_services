package com.utils.service.camel.processor.validation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReceiveSMSResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        String msg = exchange.getIn()
                .getBody(String.class);
        System.out.println("MSG =========>>>>>>>>>>   " + msg);
    }
//	}
}
