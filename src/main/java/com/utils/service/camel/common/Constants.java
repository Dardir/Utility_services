package com.utils.service.camel.common;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Constants {

	private final Environment env;

	public Constants(Environment env) {
		this.env = env;
	}

	public String getSendSMSAtomicServiceName() {
		return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_SERVICE_NAME);
	}
	public String getSendSMSBusinessServiceName() {
		return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_BUSINESS_SERVICE_NAME);
	}

}
