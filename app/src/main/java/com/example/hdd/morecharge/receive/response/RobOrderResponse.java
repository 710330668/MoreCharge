package com.example.hdd.morecharge.receive.response;

/**
 * Created by 71033 on 2018/12/3.
 */
public class RobOrderResponse {


    /**
     * success : true
     * msg : 抢单成功
     * code : 0
     * data : null
     */

    private boolean success;
    private String msg;
    private int code;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
