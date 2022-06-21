package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ServiceErrorCodesEnum {

    GENERAL_ERROR("11013");


    private final String errorCode;

    ServiceErrorCodesEnum(String errorCode) {
        this.errorCode = errorCode;
    }

    public static ServiceErrorCodesEnum fromId(String id) {
        for (ServiceErrorCodesEnum at : ServiceErrorCodesEnum.values()) {
            if (at.getErrorCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
