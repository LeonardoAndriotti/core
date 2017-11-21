package com.core.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrerDTO {

//	@JsonProperty("id")
	private BigDecimal id;
//	@JsonProperty("quant")
	private BigDecimal quant;
//	@JsonProperty("iduser")
	private BigDecimal iduser;
//	@JsonProperty("idproduto")
	private BigDecimal idproduto;
//	@JsonProperty("preco")
	private BigDecimal total;

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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}