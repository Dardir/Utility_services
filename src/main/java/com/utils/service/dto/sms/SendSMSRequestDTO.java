package com.utils.service.dto.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendSMSRequestDTO implements Serializable {
    private String msgBody;
    private String mobileNumber;
}
