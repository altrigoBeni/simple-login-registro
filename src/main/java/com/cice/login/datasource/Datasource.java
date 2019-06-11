package com.cice.login.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Datasource {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private static final Logger log = LoggerFactory.getLogger(Datasource.class);
	
	private void getConnection() throws ClassNotFoundException {
		log.info("Cargando...");
		Class.forName("com.mysql.jdbc.Driver");		
		log.info("Felicidades -  MySQL JDBC Driver Registrado!");
		
	}
	
	
	
}
