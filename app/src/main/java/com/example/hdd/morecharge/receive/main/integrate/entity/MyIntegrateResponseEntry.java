package com.example.hdd.morecharge.receive.main.integrate.entity;

public class MyIntegrateResponseEntry {


    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : {"score":119}
     */

    private boolean success;
    private String msg;
    private int code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * score : 119.0
         */

        private double score;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
}
