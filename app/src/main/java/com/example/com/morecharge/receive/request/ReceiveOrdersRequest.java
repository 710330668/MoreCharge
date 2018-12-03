package com.example.com.morecharge.receive.request;

/**
 * Created by 71033 on 2018/11/30.
 */
public class ReceiveOrdersRequest {


    /**
     * longitude : 117.070803
     * latitude : 36.666502
     * orderBy : distance
     * descOrAsc : asc
     */

    private String longitude;
    private String latitude;
    private String orderBy;
    private String descOrAsc;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getDescOrAsc() {
        return descOrAsc;
    }

    public void setDescOrAsc(String descOrAsc) {
        this.descOrAsc = descOrAsc;
    }
}
