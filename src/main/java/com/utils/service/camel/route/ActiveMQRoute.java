package com.utils.service.camel.route;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.HttpMethod;

import static org.apache.camel.model.rest.RestParamType.body;

public abstract class ActiveMQRoute extends RouteBuilder {

    public void buildEndpointRoute(String serviceName, Class<?> requestTypeClass, String toRouteName) {
        from("test-jms:queue:sms-queue").to("direct:PROCESS_SMS");

//        rest().consumes("application/json").produces("application/json").post(serviceName)
//                .type(requestTypeClass).param().name("body").type(body).description("Payload").endParam()
//                .route()
//                .to("log:INFO?showBody=true&showHeaders=true")
//                .setProperty(ConstantsEnum.OriginalMessage.getConstantValue(), simple("${body}"))
//                .setProperty(ConstantsEnum.ServiceName.getConstantValue(), constant(serviceName))
//                .to(FlowRouteNames.AUDIT_ROUTE_NAME)
//                .to(toRouteName);
    }
//    public void buildAuditRoute(String routeName, Processor requestQueueProcessor) {
//        from(routeName)
//                .setProperty(ConstantsEnum.BEFORE_AUDIT_MESSAGE.getConstantValue(), simple("${body}"))
//                .process(requestQueueProcessor)
//                .setBody(exchangeProperty(ConstantsEnum.BEFORE_AUDIT_MESSAGE.getConstantValue()));
//    }
//
//    protected void buildRestServiceCallerRoute(String routeName, HttpMethod methodName,
//                                               Processor requestProcessor,
//                                               Processor responseProcessor,
//                                               String targetServiceName,
//                                               Class<?> responseType) {
//        from(routeName).process(requestProcessor)
//                .setHeader(Exchange.HTTP_METHOD, constant(methodName.name()))
//                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
//                .marshal().json(JsonLibrary.Jackson)
//                .to("log:INFO?showBody=true&showHeaders=true")
//                .to(targetServiceName + "?bridgeEndpoint=true")
//                .unmarshal().json(JsonLibrary.Jackson, responseType)
////                .setProperty(ConstantsEnum.RestServiceResponse.getConstantValue(), simple("${body}"))
//                .process(responseProcessor);
//    }
//
//    protected void buildSOAPServiceCallerRoute(String routeName,
//                                               Processor soapRequestResponseProcessor) {
//        from(routeName).process(soapRequestResponseProcessor);
//    }
//
//
//    protected ProcessorDefinition<?> buildGeneralRoute(String routeName, Processor processor) {
//        return from(routeName)
//                .process(processor);
//    }
}