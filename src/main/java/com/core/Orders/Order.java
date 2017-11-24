package com.core.Orders;

import java.math.BigDecimal;

public class Order {

    private BigDecimal id;
    private BigDecimal idcarrer;
    private String datacriacao;
    private String datafinalizado;
    private String amount;
    private String status;

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getDatafinalizado() {
        return datafinalizado;
    }

    public void setDatafinalizado(String datafinalizado) {
        this.datafinalizado = datafinalizado;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getIdcarrer() {
		return idcarrer;
	}

	public void setIdcarrer(BigDecimal idcarrer) {
		this.idcarrer = idcarrer;
	}
	
}
