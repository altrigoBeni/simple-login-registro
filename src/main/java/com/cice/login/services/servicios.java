package com.cice.login.services;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import com.cice.login.dao.UserDao;
import com.cice.login.datasource.Datasource;
import com.mysql.jdbc.log.Log;

public class servicios {
	private static final Logger log = LoggerFactory.getLogger(servicios.class);
	static UserDao userDao = new UserDao(null, null);
	static Scanner sc = new Scanner(System.in);
	
	public static void userLogin(){
		Boolean resultLogin=false;
		
		do {
			log.info("Para logarte introduce los siguientes datos:");
			loginRequestData();
			try {
				resultLogin = Datasource.Loging(userDao.getName(), userDao.getPass());
			} catch (Exception e) {
				e.printStackTrace();
			}
						
			if (resultLogin) {log.info("El usuario " + userDao.getName() + " está registrado!!!");}
			else {			
				log.info("El usuario " + userDao.getName() + " no está registrado!!!");
				log.info("--- Primero tienes que registrarte ---");
				loginRequestData();
				try {
					Datasource.registro(userDao.getName(), userDao.getPass());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				log.info("Usuario " + userDao.getName() + " registrado");
			}			
		} while (resultLogin ==false);	
		sc.close();	
	}
	
	
	
	private static UserDao loginRequestData() {		
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
