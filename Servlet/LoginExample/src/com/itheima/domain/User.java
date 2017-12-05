package com.itheima.domain;

public class User {
	/*id int primary key auto_increment,
	username varchar(20),
	password varchar(20),
	email varchar(20),
	name varchar(20),
	sex varchar(10),
	birthday date,
	hobby varchar(50)*/
	
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
