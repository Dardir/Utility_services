package com.utils.service.camel.common;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    private final Environment env;

    public Constants(Environment env) {
        this.env = env;
    }

    public String getSMSSenderName() {
        return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_SENDER_NAME);
    }

    public String getSendSMSUserName() {
        return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_USERNAME);
    }

    public String getSendSMSPassword() {
        return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_PASSWORD);
    }

    public String getSendSMSBaseServiceURL() {
        return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_SERVICE_BASE_URL);
    }

    public String getSendSMSBusinessServiceName() {
        return env.getRequiredProperty(ConstantsConfigKeys.SEND_SMS_BUSINESS_SERVICE_NAME);
    }

}
