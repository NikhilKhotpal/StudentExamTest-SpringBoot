package com.test.studentModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class AdminLogin {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
private String email;
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
