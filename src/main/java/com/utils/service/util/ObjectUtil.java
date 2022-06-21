package com.utils.service.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectUtil {
	public static boolean isNullOrEmpty(Object data) {
		if (data == null) {
			return true;
		} else if (data instanceof String) {
			return ((String) data).isEmpty();
		} else if (data instanceof List) {
			return ((List<?>) data).isEmpty();
		}
		return false;
	}

	public static String maskAccountNumber(String accountNumber, int start, char maskChar) {
		if (ObjectUtil.isNullOrEmpty(accountNumber))
			return "";
		if (start < 0)
			start = 0;
		int end = accountNumber.length() - start;
		int maskLength = Math.max(end, start);
		if (maskLength == 0)
			return accountNumber;
		StringBuilder sbMaskString = new StringBuilder(maskLength);
		for (int i = 0; i < maskLength; i++) {
			sbMaskString.append(maskChar);
		}
		return accountNumber.substring(0, start) + sbMaskString.toString()
				+ accountNumber.substring(start + maskLength);
	}

	public static boolean isNumericText(String str) {
		return onlyDigits(str);
	}

	public static boolean isNotValidMobile(String mobileNumber) {
		// TODO Auto-generated method stub
		return ObjectUtil.isNullOrEmpty(mobileNumber) || !isNumericText(mobileNumber) || !mobileNumber.startsWith("002")
				|| mobileNumber.contains(" ") || mobileNumber.length() != 14;
	}

	public static boolean onlyDigits(String string) {
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		boolean res = matcher.matches();
		return res;
	}

}
