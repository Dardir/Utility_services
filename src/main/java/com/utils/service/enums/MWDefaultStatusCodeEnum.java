package com.utils.service.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MWDefaultStatusCodeEnum {
	ATOMIC_SUCCESS("MW_0000"), SUCCESS("0000"), GENERAL_ERROR("-9999"), BE_SOAP_NOT_AVAILABLE("-6666"),
	BE_REST_NOT_AVAILABLE("-7777"), INVALID_MOBILE_NUMBER("AT_UTIL_2"), EMPTY_BODY_OR_MOBILE_NO("AT_UTIL_3");

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
