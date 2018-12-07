package com.example.hdd.morecharge.main.login.response;

/**
 * Created by 71033 on 2018/11/26.
 */
public class VerificationCodeResponse {


    /**
     * success : true
     * msg : null
     * code : 0
     * data : b6165fc0a40c45e5ba8fa3950986fb2e
     */

    private boolean success;
    private Object msg;
    private int code;
    private String data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
