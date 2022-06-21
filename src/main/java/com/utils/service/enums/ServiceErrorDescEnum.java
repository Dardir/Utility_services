package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ServiceErrorDescEnum {

    GENERAL_ERROR("Service is currently not available from your bank, try again later");


    private final String errorDesc;

    ServiceErrorDescEnum(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public static ServiceErrorDescEnum fromId(String id) {
        for (ServiceErrorDescEnum at : ServiceErrorDescEnum.values()) {
            if (at.getErrorDesc().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
