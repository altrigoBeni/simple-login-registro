package com.cice.login;

import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;

import com.cice.login.services.servicios;

public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BasicConfigurator.configure();
		servicios.userLogin();
		
	}

}
