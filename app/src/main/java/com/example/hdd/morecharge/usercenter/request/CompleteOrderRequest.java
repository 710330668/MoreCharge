package com.example.hdd.morecharge.usercenter.request;

/**
 * Created by 71033 on 2018/12/4.
 */
public class CompleteOrderRequest {


    /**
     * orderId :
     * orderType :
     */

    private String orderId;
    private String orderType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
