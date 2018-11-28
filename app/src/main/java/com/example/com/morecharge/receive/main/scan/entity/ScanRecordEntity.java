package com.example.com.morecharge.receive.main.scan.entity;

public class ScanRecordEntity {

    private String url;
    private String userName;
    private String userTime;

    public ScanRecordEntity(String userName) {
        this.userName = userName;
    }

    public ScanRecordEntity(String url, String userName, String userTime) {
        this.url = url;
        this.userName = userName;
        this.userTime = userTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }
}
