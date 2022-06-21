package com.utils.service.camel.route;


import com.utils.service.camel.common.FlowRouteNames;
import com.utils.service.camel.processor.validation.common.GenerateServiceResponseProcessor;
import com.utils.service.camel.processor.validation.common.GlobalExceptionProcessor;
import com.utils.service.camel.processor.validation.common.RequestQueueProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommonRoutesFlow extends RestRoute {
    private final GlobalExceptionProcessor globalExceptionProcessor;
    private final RequestQueueProcessor requestQueueProcessor;
    private final GenerateServiceResponseProcessor generateServiceResponseProcessor;

    public CommonRoutesFlow(GlobalExceptionProcessor globalExceptionProcessor, RequestQueueProcessor requestQueueProcessor, GenerateServiceResponseProcessor generateServiceResponseProcessor) {
        this.globalExceptionProcessor = globalExceptionProcessor;
        this.requestQueueProcessor = requestQueueProcessor;
        this.generateServiceResponseProcessor = generateServiceResponseProcessor;
    }

    @Override
    public void configure() {

        onException(Exception.class).process(globalExceptionProcessor)
                .to(FlowRouteNames.AUDIT_ROUTE_NAME).handled(true);
//
        // Build Audit Routes

        buildAuditRoute(FlowRouteNames.AUDIT_ROUTE_NAME, requestQueueProcessor); ///////////////////////////////////////////////////////////////////////////////////
//		// Build Service Response Route

        buildGeneralRoute(FlowRouteNames.GENERATE_SERVICE_RESPONSE_ROUTE_NAME, generateServiceResponseProcessor)
                .to(FlowRouteNames.AUDIT_ROUTE_NAME).to("log:INFO?showBody=true&showHeaders=true").end();

        // Auth with E_Card
//        buildRestServiceCallerRoute("direct:PROCESS_SMS", HttpMethod.GET,
//                receiveSMSRequestProcessor, receiveSMSResponseProcessor,
//                "", Object.class);
//        mq();

//        from("jmsComponent:queue:Q1").process(new Processor() {
//            public void process(Exchange exchange) throws Exception {
//                System.out.println(exchange.getIn().getBody());
//            }
//        }).to("jmsComponent:queue:Q2");
    }
}
