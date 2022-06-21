package com.utils.service.dto.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AuditLogDto implements Serializable {


    private static final long serialVersionUID = 1L;
    private String requestId;
    private String content;
    private String dateTime;

}
