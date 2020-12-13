package com.deckofcardsapi.supportclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
	private Class className;
	private Logger logger;
	//private String testSuite;
	
	
	public Logs(Class className) {
		this.className = className;
	}
	public void createLog(String logType, String logMessage) {
		logger = LogManager.getLogger(className);
		
		switch(logType) {
		case "info":
			logger.info(logMessage);
		break;
		case "warn":
			logger.warn(logMessage);
		break;
		case "error":
			logger.error(logMessage);
		break;
		default :
			logger.info(logMessage);
		}
	}

}
