package com.example.hdd.morecharge.usercenter.response;

/**
 * Created by 71033 on 2018/12/4.
 */
public class CompleteOrderResponse {


    /**
     * success : false
     * msg : 操作失败
     * code : 500
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
