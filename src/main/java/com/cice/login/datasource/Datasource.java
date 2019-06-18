package com.cice.login.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cice.login.dao.UserDao;

public class Datasource {
	private static Connection connection = null;
	private static  PreparedStatement statement = null;
	private static final Logger log = LoggerFactory.getLogger(Datasource.class);
	
	private static void makeJDBCConnection() throws ClassNotFoundException, SQLException {
		log.info("Cargando...");
		Class.forName("com.mysql.jdbc.Driver");	
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro", "root", "root");
		if (connection != null) {
			log.info("Connection Successful! Toma toma toma");
		}else {
			log.error("MySQL Connection a pegao un pete de locos!");	
		}				
	}
	
	
	public static boolean Loging(String nombre, String pass) throws SQLException, ClassNotFoundException {
		 boolean respose = false;
 		makeJDBCConnection();
		// MySQL Select Query Tutorial
		String getQueryStatement = "SELECT * FROM `users` WHERE name=? AND password=?";

		statement = connection.prepareStatement(getQueryStatement);
		statement.setString(1, nombre);
		statement.setString(2, pass);
	
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Integer id = rs.getInt("id");
	
			if(id != null) {respose= true;}else {respose = false;}
		}
		testConnection(connection);
		return respose;

	}
	
	
	public static void registro(String nombre, String password) throws SQLException, ClassNotFoundException {		
		makeJDBCConnection();
		String insertQueryStatement = "INSERT INTO users(name, password) VALUES (?,?)";

		statement = connection.prepareStatement(insertQueryStatement);
		statement.setString(1, nombre);
		statement.setString(2, password);
		statement.executeUpdate();
		testConnection(connection);
	}
	
	private static void testConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}
	}
}
