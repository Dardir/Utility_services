package com.utils.service.dto.sms;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class SendSMSResponseDTO implements Serializable {
    private String responseCode;
    private String responseDescription;

}
