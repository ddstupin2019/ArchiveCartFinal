package com.example.demo.enity;

public class Filters {
    private boolean sezon;
    private Integer mashtab; // 0 значит нет
    private Integer relef; // 0 значит нет
    private String mesto;// пустое
    private Integer vid;
    private String group; // пустое 1=м 10 12 2=ж
    private Integer god; // 0 значит нет

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filters(Integer mashtab, String mesto, boolean sezon, String group, Integer god, Integer relef, Integer vid) {
        this.mashtab = mashtab;
        this.mesto = mesto;
        this.sezon = sezon;
        this.group = group;
        this.god = god;
        this.relef = relef;
        this.vid = vid;
    }

    public Filters() {
    }

    public Integer getMashtab() {
        return mashtab;
    }

    public String getMesto() {
        return mesto;
    }

    public boolean getSezon() {
        return sezon;
    }

    public String getGroup() {
        return group;
    }

    public Integer getGod() {
        return god;
    }

    public Integer getRelef() {
        return relef;
    }

    public Integer getVid() {
        return vid;
    }

    public void setMashtab(Integer mashtab) {
        this.mashtab = mashtab;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setSezon(boolean sezon) {
        this.sezon = sezon;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setGod(Integer god) {
        this.god = god;
    }

    public void setRelef(Integer relef) {
        this.relef = relef;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
}
