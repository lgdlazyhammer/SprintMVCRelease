package com.entity;

public class UserEntity {

	public int id;

	public String name;

	public String password;

	public UserEntity(String nameParam, String passwordParam) {
		name = nameParam;
		password = passwordParam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User name: " + name + " password: " + password;
	}

}
