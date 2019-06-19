package com.cice.login.services.impl;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cice.login.dao.UserDao;
import com.cice.login.datasource.Datasource;
import com.cice.login.services.services;

public class servicesImpl implements services{
	private final Logger log = LoggerFactory.getLogger(servicesImpl.class);
	UserDao userDao = new UserDao(null, null);
	Scanner sc = new Scanner(System.in);

	public void userLogin() {
		Boolean resultLogin=false;
		
		do {
			log.info("Para logarte introduce los siguientes datos:");
			userGetData();
			try {
				resultLogin = Datasource.Loging(userDao.getName(), userDao.getPass());
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
						
			if (resultLogin) {log.info("El usuario " + userDao.getName() + " está registrado!!!");}
			else {			
				log.warn("El usuario " + userDao.getName() + " no está registrado!!!");
				log.info("--- Primero tienes que registrarte ---");
				userGetData();
				try {
					Datasource.registro(userDao.getName(), userDao.getPass());
				} catch (ClassNotFoundException e) {
					log.error(e.getMessage());
				} catch (SQLException e) {
					log.error(e.getMessage());
				}	
				log.info("Usuario " + userDao.getName() + " registrado");
			}			
		} while (resultLogin ==false);	
		sc.close();	
		
	}

	public UserDao userGetData() {		
		String userName,userPass;
		do {
			log.info("Introduce tu nombre: ");
			userName = sc.next();
			
			log.info("Introduce tu password: ");
			userPass = sc.next();
		} while (userName == null || userPass == null);
		userDao.setName(userName);
		userDao.setPass(userPass);
		return userDao;		
	}

}
