package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MWDefaultStatusCodeEnum {

    SUCCESS("AT_UTIL_1"),
    INVALID_MOBILE_NUMBER("AT_UTIL_2"),
    EMPTY_BODY_OR_MOBILE_NO("AT_UTIL_3"),
    GENERAL_ERROR ("AT_UTIL_4"),
    ;


    private final String code;

    MWDefaultStatusCodeEnum(String code) {
        this.code = code;
    }

    public static MWDefaultStatusCodeEnum fromId(String id) {
        for (MWDefaultStatusCodeEnum at : MWDefaultStatusCodeEnum.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
