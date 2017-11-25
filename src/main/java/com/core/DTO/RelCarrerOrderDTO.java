package com.core.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelCarrerOrderDTO {
	
	private BigDecimal id;
	private BigDecimal idCarrer;
	private BigDecimal total;	
	
	public BigDecimal getIdCarrer() {
		return idCarrer;
	}
	
	public void setIdCarrer(BigDecimal idCarrer) {
		this.idCarrer = idCarrer;
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
