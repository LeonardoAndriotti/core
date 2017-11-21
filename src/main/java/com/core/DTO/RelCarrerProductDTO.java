package com.core.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelCarrerProductDTO {

// Atributos da Classe
	private BigDecimal id;
// Atributos do Carrinho
	private BigDecimal quant;
	private BigDecimal iduser;
	private BigDecimal idproduto;
	private BigDecimal total;
//	Atributos do Produto
	private String name;
    private BigDecimal price;
    private String shopping;
    private String image;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getShopping() {
		return shopping;
	}

	public void setShopping(String shopping) {
		this.shopping = shopping;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}