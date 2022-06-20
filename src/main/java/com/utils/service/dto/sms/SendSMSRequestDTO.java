package com.utils.service.dto.sms;

import lombok.Data;

@Data
public class SendSMSRequestDTO {
    private String msgBody;
    private String mobileNumber;
}
