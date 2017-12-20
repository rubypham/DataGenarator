package com.data.common;

public class Utils {
	public static int toInt(String value) {
		int result = -1;
		try {
			result = Integer.parseInt(value);
		} catch (Exception e) {
		}
		return result;
	}

	public static int optionToInt(String value) {
		int result = -1;
		switch (value) {
		case "A":
			result = 1;
			break;
		case "B":
			result = 2;
			break;
		case "C":
			result = 3;
			break;
		case "D":
			result = 4;
			break;
		case "E":
			result = 5;
			break;

		default:
			break;
		}
		return result;
	}
}
