package com.core.DTO;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersDTO {

	@JsonProperty("id")
	private BigDecimal id;
	@JsonProperty("idcarrier")
	private BigDecimal idcarrier;
	@JsonProperty("datacriacao")
	private Date datacriacao;
	@JsonProperty("datafinalizado")
	private Date datafinalizado;
	@JsonProperty("status")
	private String status;

	public enum StatusType{
		AGUARDANDO("Aguardando Pagamento"), FINALIZADO("Finalizado"), ANDAMENTO("Em andamento"); 
		
		public String tipo;
		
		private StatusType(String tipo){
			this.tipo = tipo;
		}
		
	}
	
}
