package com.utils.service.camel.route;


import com.utils.service.camel.processor.validation.ReceiveSMSRequestProcessor;
import com.utils.service.camel.processor.validation.ReceiveSMSResponseProcessor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class CommonRoutesFlow extends RestRoute {
//    private final ReceiveSMSRequestProcessor receiveSMSRequestProcessor;
//    private final ReceiveSMSResponseProcessor receiveSMSResponseProcessor;
//
//    public CommonRoutesFlow(ReceiveSMSRequestProcessor receiveSMSRequestProcessor, ReceiveSMSResponseProcessor receiveSMSResponseProcessor) {
//        this.receiveSMSRequestProcessor = receiveSMSRequestProcessor;
//        this.receiveSMSResponseProcessor = receiveSMSResponseProcessor;
//    }


    @Override
    public void configure() {

//		onException(Exception.class).process(globalExceptionProcessor)
//        .to(FlowRouteNames.AUDIT_ROUTE_NAME).handled(true);
//
//		// Build Audit Routes
//
//		buildAuditRoute(FlowRouteNames.AUDIT_ROUTE_NAME, requestQueueProcessor); ///////////////////////////////////////////////////////////////////////////////////
//		// Build Service Response Route

//		buildGeneralRoute(FlowRouteNames.GENERATE_SERVICE_RESPONSE_ROUTE_NAME, generateServiceResponseProcessor)
//
//		.to(FlowRouteNames.AUDIT_ROUTE_NAME).to("log:INFO?showBody=true&showHeaders=true").end();
        // Auth with E_Card
//        buildRestServiceCallerRoute("direct:PROCESS_SMS", HttpMethod.GET,
//                receiveSMSRequestProcessor, receiveSMSResponseProcessor,
//                "", Object.class);
//        mq();

        from("jmsComponent:queue:Q1").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getIn().getBody());
            }
        }).to("jmsComponent:queue:Q2");
    }
}
