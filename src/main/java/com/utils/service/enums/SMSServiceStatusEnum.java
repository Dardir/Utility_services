package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum SMSServiceStatusEnum {

    SUCCESS("Success"),
    ERROR_FIRE("Error Fire"),
    INVALID_MOBILE("Mobile !Digit"),
    EMPTY_BODY("Body Empty"),
    ;


    private final String errorDescription;

    SMSServiceStatusEnum(String value) {
        this.errorDescription = value;
    }

    public static SMSServiceStatusEnum fromId(String id) {
        for (SMSServiceStatusEnum at : SMSServiceStatusEnum.values()) {
            if (at.getErrorDescription().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
