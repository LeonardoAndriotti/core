package com.core.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private String fone;

    private String mobile;

    private Andress andress;

    private Login login;

    public User(BigDecimal id) {
        this.id = id;
    }

    public User() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Andress getAndress() {
        return andress;
    }

    public void setAndress(Andress andress) {
        this.andress = andress;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
