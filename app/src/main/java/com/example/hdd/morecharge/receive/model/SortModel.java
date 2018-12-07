package com.example.hdd.morecharge.receive.model;

/**
 * Created by 71033 on 2018/11/21.
 */
public class SortModel {

    private String statusName;

    private String statusCode;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public SortModel(String statusName, String statusCode) {
        this.statusName = statusName;
        this.statusCode = statusCode;
    }
}
