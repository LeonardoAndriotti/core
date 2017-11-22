package com.core.Orders;

public class Order {

    private Long id;
    private Long idcarrier;
    private String datacriacao;
    private String datafinalizado;
    private String amount;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcarrier() {
        return idcarrier;
    }

    public void setIdcarrier(Long idcarrier) {
        this.idcarrier = idcarrier;
    }

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
}
