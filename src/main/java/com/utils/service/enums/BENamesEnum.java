package com.utils.service.enums;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum BENamesEnum {

    MW("MW"),
    IMAL("IMAL"),
    NI("NI"),
    ECARDS("ECARDS"),
    EZAGEL("EZAGEL");


    private final String beName;

    BENamesEnum(String beName) {
        this.beName = beName;
    }

    public static BENamesEnum fromId(String id) {
        for (BENamesEnum at : BENamesEnum.values()) {
            if (at.getBeName().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
