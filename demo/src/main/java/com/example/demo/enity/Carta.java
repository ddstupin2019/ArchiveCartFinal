package com.example.demo.enity;

public class Carta {
    private Integer id;
    private String cart; //ссылка на карту
    private Integer mashtab;
    private Integer relef;
    private String mesto;
    private Integer vid; // 0 класика, 1 лонг, 2 спринт, 3 выбор, 4 рогейн
    private Integer god;
    private Boolean sezon; // true зима, false лето
    private String group;


    public Carta() {
    }

    public Carta(Integer id, String cart, Integer mashtab, Integer relef, String mesto, Integer vid, Integer god, Boolean sezon, String group) {
        this.id = id;
        this.cart = cart;
        this.mashtab = mashtab;
        this.relef = relef;
        this.mesto = mesto;
        this.vid = vid; // 0-спринт, 1-класика, 2-лонг,3-выбор, 4-рогейн
        this.god = god;
        this.sezon = sezon;
        this.group=group;
    }

    public String getGroup() {
        return group;
    }

    public Integer getId() {
        return id;
    }

    public String getCart() {
        return cart;
    }

    public Integer getMashtab() {
        return mashtab;
    }

    public Integer getRelef() {
        return relef;
    }

    public String getMesto() {
        return mesto;
    }

    public Integer getVid() {
        return vid;
    }

    public Integer getGod() {
        return god;
    }

    public Boolean getSezon() {
        return sezon;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public void setMashtab(Integer mashtab) {
        this.mashtab = mashtab;
    }

    public void setRelef(Integer relef) {
        this.relef = relef;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public void setGod(Integer god) {
        this.god = god;
    }

    public void setSezon(Boolean sezon) {
        this.sezon = sezon;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
