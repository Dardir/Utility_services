package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum SMSResponseCodesEnum {

    SUCCESS_CODE("0000"),
    ERROR_FIRE_CODE("1101"),
    INVALID_MOBILE_CODE("1201"),
    EMPTY_BODY_CODE("1301"),
    EMPTY_MOB_CODE("1401"),
    ;


    private final String errorCode;

    SMSResponseCodesEnum(String value) {
        this.errorCode = value;
    }

    public static SMSResponseCodesEnum fromId(String id) {
        for (SMSResponseCodesEnum at : SMSResponseCodesEnum.values()) {
            if (at.getErrorCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
