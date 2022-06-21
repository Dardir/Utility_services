package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ConstantsEnum {

    AuthType("AuthType"),
    ServiceName("ServiceName"),
    CIF_DETAILS("CIF_DETAILS"),
    ACCOUNT_DETAILS("ACCOUNT_DETAILS"),
    IS_RESET_PIN("IS_RESET_PIN"),
    OriginalMessage("OriginalRequest"),
    OriginalRequestId("OriginalRequestId"),
    BEFORE_AUDIT_MESSAGE("BEFORE_AUDIT_MESSAGE"),
    SOAPServiceResponse("SOAPServiceResponse"),
    RestServiceResponse("RestServiceResponse"),
    AUTH_RECORD("NATIONAL_ID"),
    AVAILABLE_BALANCE("Balance"),
    CARD_VALIDATION_RESPONSE("CARD_VALIDATION_RESPONSE"),
    MOBILE_LENGTH("11");


    private final String constantValue;

    ConstantsEnum(String constantValue) {
        this.constantValue = constantValue;
    }

    public static ConstantsEnum fromId(String id) {
        for (ConstantsEnum at : ConstantsEnum.values()) {
            if (at.getConstantValue().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
