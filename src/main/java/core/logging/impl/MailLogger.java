package main.java.core.logging.impl;

import main.java.core.logging.abstr.ILogger;

public class MailLogger implements ILogger {
	public void log(String data) {
		System.out.println("Mail gönderildi: " + data);
	}
}