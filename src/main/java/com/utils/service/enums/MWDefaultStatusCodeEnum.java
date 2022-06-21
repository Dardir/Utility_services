package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MWDefaultStatusCodeEnum {

    SUCCESS("0000"),
    GENERAL_ERROR("-9999"),
    
    MISSING_REQUIRED_FIELD_ERROR("AT_FIN_2"),
    UNSUPPORTED_CARD_TYPE_ERROR("AT_FIN_3"),
    E_CARD_UNAUTH_ERROR("-8888"),
    REVERSE_TRANSACTION_NOT_FOUND("AT_FIN_5"),
    REVERSE_TRANSACTION_FOUND_WITH_FAIL("AT_FIN_6"),
    REVERSE_TRANSACTION_FOUND_NOT_DEBIT("AT_FIN_7"),
    DUPLICATE_TRANS("AT_FIN_8"),
    REVERSE_TRANSACTION_FOUND("AT_FIN_9"),
    TRANSACTION_FAILED_AT_CORE("AT_FIN_10"),
    TRANSACTION_LIST_NOT_FOUND("AT_FIN_11"),
    MISMATCH_REVERSED_AMOUNT("AT_FIN_12"),
    INSUF_FUND("AT_FIN_13"),
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
