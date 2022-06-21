package com.utils.service.dto.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceHeader {
    private String responseCode;
    private String responseDesc;

    public ServiceHeader(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }
}
