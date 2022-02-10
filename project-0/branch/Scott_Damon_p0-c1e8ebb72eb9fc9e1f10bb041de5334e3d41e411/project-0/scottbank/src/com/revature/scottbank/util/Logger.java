package com.revature.scottbank.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Logger {
	
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_RESET = "\u001B[0m";

	private static Logger logger;
	private final boolean printToConsole;
	
	private Logger(boolean printToConsole) {
		this.printToConsole = printToConsole;
	}
	
	public static Logger getLogger(boolean printToConsole) {

		if(logger == null) {
			logger = new Logger(printToConsole);
		}
		
		return logger;
	}
	
	public void log(String message) {
		try(Writer logWriter = new FileWriter("resources/scottbank.log", true);) {
			
			logWriter.write(message + "\n");
			
			if(printToConsole) {
				System.out.println(ANSI_GREEN + message + ANSI_RESET);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}