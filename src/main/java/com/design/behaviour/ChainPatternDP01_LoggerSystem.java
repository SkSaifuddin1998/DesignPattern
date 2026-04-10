// Step 1: Define an abstract Handler class
package com.design.behaviour;

//Step 1: Define an abstract Handler class
abstract class Logger {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	protected int logLevel;

	// Next handler in the chain
	protected Logger nextLogger;

	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if (this.logLevel <= level) {
			write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);
}

//Step 2: Define Concrete Handlers
class InfoLogger extends Logger {

	public InfoLogger(int level) {
		this.logLevel = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("INFO: " + message);
	}
}

class DebugLogger extends Logger {

	public DebugLogger(int level) {
		this.logLevel = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("DEBUG: " + message);
	}
}

class ErrorLogger extends Logger {

	public ErrorLogger(int level) {
		this.logLevel = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("ERROR: " + message);
	}
}

//Step 3: Configure the chain
public class ChainPatternDP01_LoggerSystem {

	private static Logger getChainOfLoggers() {
		Logger errorLogger = new ErrorLogger(Logger.ERROR);
		Logger debugLogger = new DebugLogger(Logger.DEBUG);
		Logger infoLogger = new InfoLogger(Logger.INFO);

		infoLogger.setNextLogger(debugLogger);
		debugLogger.setNextLogger(errorLogger);

		return infoLogger; // The first logger in the chain
	}

	public static void main(String[] args) {
		Logger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(Logger.INFO, "This is an information.");
		loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");
		loggerChain.logMessage(Logger.ERROR, "This is an error information.");
	}
}
