package com.qjkobe.utils;

public class UUID {

	public static String getID() {
		String str = java.util.UUID.randomUUID().toString();
		str = str.replaceAll("-", "");
		return str;
	}

}
