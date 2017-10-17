package com.core.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.model.User;

@Entity
@Table(name = "physical_person")
@AttributeOverride(name = "createDate", column = @Column(name = "std_entry_date"))
public class PhysicalPerson extends User {

	private static final long serialVersionUID = 1L;

	@Column(length = 60)
	private String name;

	private String nickname;

	private String cpf;

	public PhysicalPerson() {

	}

	public PhysicalPerson(BigDecimal id, String cpf, String name, String nickname) {
		super(id);
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
