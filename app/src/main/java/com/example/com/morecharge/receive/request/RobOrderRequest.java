package com.example.com.morecharge.receive.request;

/**
 * Created by 71033 on 2018/12/3.
 */
public class RobOrderRequest {


    /**
     * orderId : 1049119511306016666
     * orderType : BUILD_PERSON_WOOD
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
