package com.utils.service.camel.processor.validation;

import com.utils.service.service.ServiceCaller;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReceiveSMSRequestProcessor implements Processor {

    private final ServiceCaller serviceCaller;

    public ReceiveSMSRequestProcessor(ServiceCaller serviceCaller) {
        this.serviceCaller = serviceCaller;
    }

    @Override
    public void process(Exchange exchange) {
        String msg = exchange.getIn()
                .getBody(String.class);
        System.out.println("MSG =========>>>>>>>>>>   " + msg);
        Object res = serviceCaller.sendRestRequest("https://www.ezagel.com/portex_ws/service.asmx/Send_SMS?Msg_ID=54335359_779&Mobile_NO=00201157010937&Body=Hello22&Validty&StartTime&Sender=BARAKA_EGY&User=BARAKA Test&Password=Bara@1234&Service=&Validty=&StartTime=",
                String.class);
        System.out.println("RES =========>>>>>>>>>>   " + res);

    }
//	}
}
