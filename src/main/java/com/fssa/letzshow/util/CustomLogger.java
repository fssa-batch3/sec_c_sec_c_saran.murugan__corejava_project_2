package com.fssa.letzshow.util;

public class CustomLogger {
	private CustomLogger() {
		super();
	}
	private static boolean isDebugEnabled = true;

	public static void info(Object obj) {
		System.out.println(obj);
	}

	public static void debug(String message) {
		if (isDebugEnabled) {
			System.out.println("[DEBUG] " + message);
		}
	}

	
}
