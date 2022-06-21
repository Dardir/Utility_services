package com.utils.service.camel.route;

import com.utils.service.camel.common.FlowRouteNames;
import com.utils.service.dto.sms.SendSMSResponseDTO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

import static org.apache.camel.model.rest.RestParamType.body;

public abstract class RestRoute extends RouteBuilder {

    public void buildEndpointRoute(String serviceName, Class<?> requestTypeClass, String toRouteName) {
        rest().consumes("application/json")
                .produces("application/json").post(serviceName)
                .type(requestTypeClass).param()
                .name("body").type(body).description("Payload").endParam()
                .route()
                .to("log:INFO?showBody=true&showHeaders=true")
//                .setProperty(ConstantsEnum.OriginalMessage.getConstantValue(), simple("${body}"))
//                .setProperty(ConstantsEnum.ServiceName.getConstantValue(), constant(serviceName))
//                .to(FlowRouteNames.AUDIT_ROUTE_NAME)
                .to(toRouteName);
    }

    public void buildAuditRoute(String routeName, Processor requestQueueProcessor) {
        from(routeName)
                .setProperty(ConstantsEnum.BEFORE_AUDIT_MESSAGE.getConstantValue(), simple("${body}"))
                .process(requestQueueProcessor)
                .setBody(exchangeProperty(ConstantsEnum.BEFORE_AUDIT_MESSAGE.getConstantValue()));
    }
    protected ProcessorDefinition<?> buildGeneralRoute(String routeName, Processor processor) {
        return from(routeName)
                .process(processor);
    }
}