package com.example.hdd.morecharge.receive.main.integrate.entity;

public class IntegrateEntity {

    private String title;
    private int holderType;

    public IntegrateEntity() {
    }

    public IntegrateEntity(String title) {
        this.title = title;
    }

    public IntegrateEntity(String title, int holderType) {
        this.title = title;
        this.holderType = holderType;
    }

    public int getHolderType() {
        return holderType;
    }

    public void setHolderType(int holderType) {
        this.holderType = holderType;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
