package com.cice.login;

import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;

import com.cice.login.services.impl.servicesImpl;

public class Main {
	
	static servicesImpl servicesImpl = new servicesImpl();

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BasicConfigurator.configure();
		servicesImpl.userLogin();
		
	}

}
