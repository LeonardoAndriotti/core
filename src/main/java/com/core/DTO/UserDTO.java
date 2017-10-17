package com.core.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
	@JsonProperty("id")
	private BigDecimal id;
	@JsonProperty("name")
	private String username;
	@JsonProperty("nickname")
	private String nickname;
	private LoginDTO login;
	private AndressDTO andress;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

	public AndressDTO getAndress() {
		return andress;
	}

	public void setAndress(AndressDTO andress) {
		this.andress = andress;
	}

}
