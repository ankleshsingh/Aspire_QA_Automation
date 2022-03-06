package com.aspire.utils;

import org.apache.log4j.Logger;

import com.aspire.utils.listeners.LogListener;

/**
 * The Class has all Logging related utilities.
 *
 * @author Anklesh Singh
 */
public class LoggerUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LogListener.class);

	/**
	 * Logs info
	 * 
	 * @author Anklesh Singh
	 * @param message the message
	 */
	public static void log(String message) {
		logger.info(message);
	}

	/**
	 * Gets the logger.
	 * 
	 * @author Anklesh Singh
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
