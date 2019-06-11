package com.cice.login;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		log.debug("Estoy en modo debug");
		log.info("Estoy en modo info");
		log.warn("Estoy en modo warn");
		log.error("Estoy en modo error");

	}

}
