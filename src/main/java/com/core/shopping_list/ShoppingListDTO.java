package com.core.shopping_list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingListDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean notification;

    private Boolean weekly;

    private Boolean monthly;

    private Boolean onlyOnce;

    private String alertDate;

    private String dayWeek;

    private String dayMonth;

    private String color;

    private Long idClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Boolean getWeekly() {
        return weekly;
    }

    public void setWeekly(Boolean weekly) {
        this.weekly = weekly;
    }

    public Boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(Boolean monthly) {
        this.monthly = monthly;
    }

    public Boolean getOnlyOnce() {
        return onlyOnce;
    }

    public void setOnlyOnce(Boolean onlyOnce) {
        this.onlyOnce = onlyOnce;
    }

    public String getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
