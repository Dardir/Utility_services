package com.utils.service.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "jss.camel.rest-dsl.enabled", havingValue = "true")
public class RestDsl extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true").apiContextPath("/api-doc")
				.apiProperty("api.title", "Saggu.UK Camel Rest APIs").apiProperty("api.version", "1.0")
				.apiContextListing(true);

	}

}
