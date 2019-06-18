package com.cice.login.dao;

public class UserDao {

	private Integer id;
	private String name,pass;
	
	public UserDao() {
		super();
	}

	public UserDao(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public UserDao(Integer id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + "]";
	}	
	
}
