package com.utils.service.camel.route;

import com.utils.service.camel.common.FlowRouteNames;
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

//    protected void mq(){
//        from("activemq:queue:sms-queue").to("direct:PROCESS_SMS");
//    }

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
//
//    protected void buildRestServiceCallerRoute(String routeName,
//                                               HttpMethod methodName,
//                                               Processor requestProcessor,
//                                               Processor responseProcessor,
//                                               String targetServiceName,
//                                               Class<?> responseType)
//    {
////        Map<String,String> parameters= new HashMap<>();
//////        [{Body=Hello, Mobile_NO=00201009991192, Msg_ID=543353577, Password=Bara@1234, Sender=BARAKA EGYT, Service=, StartTime=[, ], User=BARAKA Test, Validty=[, ]}]
////        parameters.put("Body","Hello");
////        parameters.put("Mobile_NO","00201009991192");
////        parameters.put("Msg_ID","54335357787");
////        parameters.put("Password","Bara@1234");
////        parameters.put("Sender","Hello");
////        parameters.put("StartTime","");
////        parameters.put("User","BARAKA Test");
////        parameters.put("Validty","");
//        from(routeName).process(requestProcessor)
//                .setHeader(Exchange.HTTP_METHOD, constant(methodName.name()))
//                .setHeader(Exchange.CONTENT_TYPE,
//                        constant("application/xml"))
//                .marshal().json(JsonLibrary.Jackson)
//                .to("log:INFO?showBody=true&showHeaders=true")
//                .to(targetServiceName + "?bridgeEndpoint=true")
////                .unmarshal().jacksonxml(responseType)
////                .setProperty(ConstantsEnum.RestServiceResponse.getConstantValue(), simple("${body}"))
//                .process(responseProcessor);
//    }

    protected ProcessorDefinition<?> buildGeneralRoute(String routeName, Processor processor) {
        return from(routeName)
                .process(processor);
    }
}