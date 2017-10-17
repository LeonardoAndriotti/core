package com.core.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {

    @Column(length = 100)
	private String login;
    
    @Column(length = 16)
	private String password;
    
	
	
	public Login(BigDecimal id, String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Login(){}
	

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
