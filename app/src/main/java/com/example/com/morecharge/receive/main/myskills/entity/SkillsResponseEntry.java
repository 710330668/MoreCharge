package com.example.com.morecharge.receive.main.myskills.entity;

import java.util.List;

public class SkillsResponseEntry  {


    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : [{"groupName":"城市建筑","groupVal":[{"isHave":"N","code":"BUILD_PERSON_MU-J","name":"木工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_MU-Z","name":"木工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WA-J","name":"瓦工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WA-Z","name":"瓦工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_SHUI-J","name":"水工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_SHUI-Z","name":"水工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_BANYUN-J","name":"搬运工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_BANYUN-Z","name":"搬运工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_QINGLI-J","name":"清理工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_QINGLI-Z","name":"清理工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_DIAN-J","name":"电工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_DIAN-Z","name":"电工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_XIAO-J","name":"小工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_XIAO-Z","name":"小工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WAG-J","name":"瓦工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WAG-Z","name":"瓦工[壮工]","text":null},{"isHave":"N","code":"BUILD_PROJECT_SHUI","name":"水","text":null},{"isHave":"N","code":"BUILD_PROJECT_DIAN","name":"电","text":null}]},{"groupName":"顺风腿","groupVal":[{"isHave":"N","code":"WAY_EXPRESS","name":"取送件","text":null},{"isHave":"N","code":"WAY_BUY","name":"代购","text":null}]},{"groupName":"保洁","groupVal":[{"isHave":"N","code":"CLEANUP_APPARATUS","name":"清洗家电","text":null},{"isHave":"N","code":"CLEANUP_CLEAN","name":"打扫卫生","text":null}]},{"groupName":"兼职","groupVal":[{"isHave":"N","code":"TIME_JOB_PAGE","name":"传单","text":null},{"isHave":"N","code":"TIME_JOB_WAITER","name":"服务员","text":null},{"isHave":"N","code":"TIME_JOB_SHOW","name":"商演","text":null}]}]
     */

    private boolean success;
    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * groupName : 城市建筑
         * groupVal : [{"isHave":"N","code":"BUILD_PERSON_MU-J","name":"木工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_MU-Z","name":"木工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WA-J","name":"瓦工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WA-Z","name":"瓦工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_SHUI-J","name":"水工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_SHUI-Z","name":"水工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_BANYUN-J","name":"搬运工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_BANYUN-Z","name":"搬运工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_QINGLI-J","name":"清理工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_QINGLI-Z","name":"清理工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_DIAN-J","name":"电工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_DIAN-Z","name":"电工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_XIAO-J","name":"小工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_XIAO-Z","name":"小工[壮工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WAG-J","name":"瓦工[技工]","text":null},{"isHave":"N","code":"BUILD_PERSON_WAG-Z","name":"瓦工[壮工]","text":null},{"isHave":"N","code":"BUILD_PROJECT_SHUI","name":"水","text":null},{"isHave":"N","code":"BUILD_PROJECT_DIAN","name":"电","text":null}]
         */

        private String groupName;
        private List<GroupValBean> groupVal;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<GroupValBean> getGroupVal() {
            return groupVal;
        }

        public void setGroupVal(List<GroupValBean> groupVal) {
            this.groupVal = groupVal;
        }

        public static class GroupValBean {
            /**
             * isHave : N
             * code : BUILD_PERSON_MU-J
             * name : 木工[技工]
             * text : null
             */

            private String isHave;
            private String code;
            private String name;
            private Object text;

            public String getIsHave() {
                return isHave;
            }

            public void setIsHave(String isHave) {
                this.isHave = isHave;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getText() {
                return text;
            }

            public void setText(Object text) {
                this.text = text;
            }
        }
    }
}
