package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum SMSResponseCodeDescriptionEnum {

    SUCCESS("Success"),
    ERROR_FIRE("Internal Error"),
    INVALID_MOBILE("Invalid Mobile Number"),
    EMPTY_Body("Empty Body"),
    EMPTY_Mobile_Number("Empty Mobile Number")
    ;


    private final String errorDescription;

    SMSResponseCodeDescriptionEnum(String value) {
        this.errorDescription = value;
    }

    public static SMSResponseCodeDescriptionEnum fromId(String id) {
        for (SMSResponseCodeDescriptionEnum at : SMSResponseCodeDescriptionEnum.values()) {
            if (at.getErrorDescription().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
