package com.core.model;

import java.math.BigDecimal;


public class JuridicalPerson extends User {

    private static final long serialVersionUID = 1L;

    private String company;

    private String trade;
    private String cnpj;

    public JuridicalPerson(BigDecimal id, String company, String trade, String cnpj) {
        super(id);
        this.company = company;
        this.trade = trade;
        this.cnpj = cnpj;
    }

    public String getCompany() {
        return company;
    }

    public String getTrade() {
        return trade;
    }

    public String getCnpj() {
        return cnpj;
    }
}
