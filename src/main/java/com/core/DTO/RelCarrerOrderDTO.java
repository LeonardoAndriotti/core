package com.core.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelCarrerOrderDTO {
	
	private BigDecimal id;
	private BigDecimal idcarrer;
	private BigDecimal total;	
	
	public BigDecimal getIdcarrer() {
		return idcarrer;
	}
	
	public void setIdcarrer(BigDecimal idcarrer) {
		this.idcarrer = idcarrer;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}

}
