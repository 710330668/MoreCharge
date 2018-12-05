package com.example.hdd.morecharge.receive.main.address.entity;

public class GoodsLocationChoosEntity {

    private String locationZone;
    private String locationDetail;

    public GoodsLocationChoosEntity() {
    }

    public GoodsLocationChoosEntity(String locationZone, String locationDetail) {
        this.locationZone = locationZone;
        this.locationDetail = locationDetail;
    }

    public String getLocationZone() {
        return locationZone;
    }

    public void setLocationZone(String locationZone) {
        this.locationZone = locationZone;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }
}
