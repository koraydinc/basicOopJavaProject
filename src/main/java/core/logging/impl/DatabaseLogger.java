package main.java.core.logging.impl;

import main.java.core.logging.abstr.ILogger;

public class DatabaseLogger implements ILogger {
	public void log(String data) {
		System.out.println("Dosya database'e loglandı: " + data);
	}
}