package com.core.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrerLeoDTO {

    //	@JsonProperty("id")
    private BigDecimal id;
    //	@JsonProperty("quantidade")
    private BigDecimal quantidade;
    //	@JsonProperty("idUser")
    private BigDecimal idUser;
    //	@JsonProperty("idProduto")
    private BigDecimal idProduto;
    //	@JsonProperty("preco")
    private BigDecimal preco;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}