package main.java.core.logging.impl;

import main.java.core.logging.abstr.ILogger;

public class FileLogger implements ILogger {
	public void log(String data) {
		System.out.println("Dosya local'e loglandı: " + data);
	}
}
