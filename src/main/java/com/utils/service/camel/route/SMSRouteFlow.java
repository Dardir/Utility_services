package com.utils.service.camel.route;

import com.utils.service.camel.common.Constants;
import com.utils.service.camel.common.FlowRouteNames;
import com.utils.service.camel.processor.validation.ReceiveSMSRequestProcessor;
import com.utils.service.camel.processor.validation.ReceiveSMSResponseProcessor;
import com.utils.service.dto.sms.SendSMSRequestDTO;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class SMSRouteFlow extends RestRoute {

    final private ReceiveSMSRequestProcessor receiveSMSRequestProcessor;
    final private ReceiveSMSResponseProcessor receiveSMSResponseProcessor;
    final private Constants constants;

    public SMSRouteFlow(ReceiveSMSRequestProcessor receiveSMSRequestProcessor, ReceiveSMSResponseProcessor receiveSMSResponseProcessor, Constants constants) {
        this.receiveSMSRequestProcessor = receiveSMSRequestProcessor;
        this.receiveSMSResponseProcessor = receiveSMSResponseProcessor;
        this.constants = constants;
    }

    @Override
    public void configure() {
        onException(Exception.class).handled(true);


        // Build end points Route
        buildEndpointRoute(constants.getSendSMSBusinessServiceName(),
                SendSMSRequestDTO.class,
                FlowRouteNames.SEND_SMS_SERVICE_ROUTE);

        buildGeneralRoute(FlowRouteNames.SEND_SMS_SERVICE_ROUTE,
                receiveSMSRequestProcessor);
    }
}
