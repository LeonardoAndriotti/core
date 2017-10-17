package com.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrer")
public class Carrer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	
	private BigDecimal quant;
	
	private BigDecimal iduser;
	
	private BigDecimal idproduto;
	
	private BigDecimal preco;
	
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getQuant() {
		return quant;
	}

	public void setQuant(BigDecimal quant) {
		this.quant = quant;
	}

	public BigDecimal getIduser() {
		return iduser;
	}

	public void setIduser(BigDecimal iduser) {
		this.iduser = iduser;
	}

	public BigDecimal getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(BigDecimal idproduto) {
		this.idproduto = idproduto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
