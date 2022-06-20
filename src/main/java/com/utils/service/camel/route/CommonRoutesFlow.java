package com.utils.service.camel.route;


import org.springframework.stereotype.Component;

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

//        from("jmsComponent:queue:Q1").process(new Processor() {
//            public void process(Exchange exchange) throws Exception {
//                System.out.println(exchange.getIn().getBody());
//            }
//        }).to("jmsComponent:queue:Q2");
    }
}
