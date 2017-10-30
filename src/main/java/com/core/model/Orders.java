package com.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;
    private BigDecimal idcarrier;
    private Date datacriacao;
    private Date datafinalizado;
    private String status;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdcarrier() {
        return idcarrier;
    }

    public void setIdcarrier(BigDecimal idcarrier) {
        this.idcarrier = idcarrier;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDatafinalizado() {
        return datafinalizado;
    }

    public void setDatafinalizado(Date datafinalizado) {
        this.datafinalizado = datafinalizado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
