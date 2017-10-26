package com.core.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.model.User;


public class JuridicalPerson extends User {

	private static final long serialVersionUID = 1L;

	private String company;
	
	private String trade;
	private String cnpj;

	public JuridicalPerson(BigDecimal id, String company, String trade, String cnpj) {
		super(id);
		this.company = company;
		this.trade = trade;
		this.cnpj = cnpj;
	}

	public String getCompany() {
		return company;
	}

	public String getTrade() {
		return trade;
	}

	public String getCnpj() {
		return cnpj;
	}
}
