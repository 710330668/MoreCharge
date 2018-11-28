package com.example.com.morecharge.receive.main.address.entity;

public class AddressEntity {

    private String title;
    private int holderType;


    public AddressEntity() {
    }

    public AddressEntity(String title, int holderType) {
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
