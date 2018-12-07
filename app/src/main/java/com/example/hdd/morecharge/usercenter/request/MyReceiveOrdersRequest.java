package com.example.hdd.morecharge.usercenter.request;

/**
 * Created by 71033 on 2018/12/4.
 */
public class MyReceiveOrdersRequest {


    /**
     * orderState : FINISH
     * pageNum : 1
     * pageSize : 10
     */

    private String orderState;
    private String pageNum;
    private String pageSize;

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
