package com.core.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {

    private BigDecimal id;

    private String name;

    private List<CategoryDTO> children;

    private BigDecimal idFather;

    public List<CategoryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDTO> children) {
        this.children = children;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIdFather() {
        return idFather;
    }

    public void setIdFather(BigDecimal idFather) {
        this.idFather = idFather;
    }

}
