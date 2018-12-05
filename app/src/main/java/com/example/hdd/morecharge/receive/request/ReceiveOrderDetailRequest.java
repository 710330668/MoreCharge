package com.example.hdd.morecharge.receive.request;

/**
 * Created by 71033 on 2018/12/3.
 */
public class ReceiveOrderDetailRequest {


    /**
     * orderId : 1061833135170445314
     * orderType : TIME_JOB_SHOW
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
