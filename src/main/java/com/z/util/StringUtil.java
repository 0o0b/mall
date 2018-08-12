package com.z.util;

import java.util.Arrays;
import java.util.Collection;

public class StringUtil {

	public static String getNullOrTrim(String str) {
		return isNotNullNorEmpty(str) ? str.trim() : null;
	}

	public static boolean isNotNullNorEmpty(Object str) {
		return str != null && str.toString().trim().length() > 0;
	}

	public static boolean isNullOrEmpty(Object str) {
		return !isNotNullNorEmpty(str);
	}

	public static String join(Collection<?> collection, String connector) {
		try {
			if (collection == null || collection.isEmpty() || connector == null)
				return null;

			String result = "";
			for (Object object : collection)
				result += connector + object;
			if (result.length() > 0)
				result = result.substring(connector.length());
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static <T> String join(T[] a, String connector) {
		return join(Arrays.asList(a), connector);
	}

	public static String joinExceptNullAndEmpty(Collection<?> collection, String connector) {
		try {
			if (collection == null || connector == null)
				return null;

			String result = "";
			for (Object object : collection)
				if (isNotNullNorEmpty(object))
					result += connector + object;
			if (result.length() > 0)
				result = result.substring(connector.length());
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public static <T> String joinExceptNullAndEmpty(T[] a, String connector) {
		return joinExceptNullAndEmpty(Arrays.asList(a), connector);
	}

	public static String splitAndJoin(String str, String seperator, String connector) {
		try {
			return join(str.split(seperator), connector);
		} catch (Exception e) {
			return null;
		}
	}

	public static String splitAndJoin(String str, String seperator, int limit, String connector) {
		try {
			return join(str.split(seperator, limit), connector);
		} catch (Exception e) {
			return null;
		}
	}

	public static String splitAndJoinForSQLLike(String str) {
		return splitAndJoin(str, "", -1, "%");
	}

	public static String substring(String str, int beginIndex, int endIndex) {
		if (str == null)
			return null;

		int length = str.length();
		if (length <= beginIndex)
			return "";

		if (length <= endIndex)
			return str.substring(beginIndex);

		return str.substring(beginIndex, endIndex);
	}

	public static String remove(String str, String oldChar) {
		return str == null ? null : str.replace(oldChar, "");
	}
}