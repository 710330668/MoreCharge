package com.example.com.morecharge.receive.main.myskills.entity;

public class SkillResetResponse  {


    /**
     * success : true
     * msg : 操作成功
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
