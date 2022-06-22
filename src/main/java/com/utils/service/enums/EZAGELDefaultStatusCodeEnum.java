package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum EZAGELDefaultStatusCodeEnum {

    SUCCESS("Success"),
    ERROR_FIRE("Error Fire"),
    INVALID_MOBILE("Mobile !Digit"),
    EMPTY_BODY("Body Empty"),
    ;

    private final String code;

    EZAGELDefaultStatusCodeEnum(String code) {
        this.code = code;
    }

    public static EZAGELDefaultStatusCodeEnum fromId(String id) {
        for (EZAGELDefaultStatusCodeEnum at : EZAGELDefaultStatusCodeEnum.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
