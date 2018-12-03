package com.example.com.morecharge.receive.response;

import java.util.List;

/**
 * Created by 71033 on 2018/12/3.
 */
public class ReceiveOrderDetailResponse {


    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : {"role":"EMPLOYER","employerInfo":{"commentState":"N","id":"127","orderState":"NEED_PAY"},"orderInfo":{"id":"1061833135170445314","createBy":"127","createTime":"2018-11-12 12:08:42","modifyBy":null,"modifyTime":null,"code":"201811121061833135191416833","orderType":"TIME_JOB_SHOW","province":"省","city":"市","area":"区","address":"街道地址","house":"房间号","linkman":"联系人","sex":"性别","phone":"手机号","longitude":"经度","latitude":"纬度","workBegin":"2018-10-11","workEnd":"2018-10-11","oneDayBegin":"14:18:24","oneDayEnd":"14:18:41","salary":122,"per":null,"workerSalary":97.6,"depositSalary":0,"residueSalary":0,"describeText":"文字描述","files":null,"orderTypeName":"商演"},"workerInfo":[]}
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
         * role : EMPLOYER
         * employerInfo : {"commentState":"N","id":"127","orderState":"NEED_PAY"}
         * orderInfo : {"id":"1061833135170445314","createBy":"127","createTime":"2018-11-12 12:08:42","modifyBy":null,"modifyTime":null,"code":"201811121061833135191416833","orderType":"TIME_JOB_SHOW","province":"省","city":"市","area":"区","address":"街道地址","house":"房间号","linkman":"联系人","sex":"性别","phone":"手机号","longitude":"经度","latitude":"纬度","workBegin":"2018-10-11","workEnd":"2018-10-11","oneDayBegin":"14:18:24","oneDayEnd":"14:18:41","salary":122,"per":null,"workerSalary":97.6,"depositSalary":0,"residueSalary":0,"describeText":"文字描述","files":null,"orderTypeName":"商演"}
         * workerInfo : []
         */

        private String role;
        private EmployerInfoBean employerInfo;
        private OrderInfoBean orderInfo;
        private List<?> workerInfo;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public EmployerInfoBean getEmployerInfo() {
            return employerInfo;
        }

        public void setEmployerInfo(EmployerInfoBean employerInfo) {
            this.employerInfo = employerInfo;
        }

        public OrderInfoBean getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfoBean orderInfo) {
            this.orderInfo = orderInfo;
        }

        public List<?> getWorkerInfo() {
            return workerInfo;
        }

        public void setWorkerInfo(List<?> workerInfo) {
            this.workerInfo = workerInfo;
        }

        public static class EmployerInfoBean {
            /**
             * commentState : N
             * id : 127
             * orderState : NEED_PAY
             */

            private String commentState;
            private String id;
            private String orderState;

            public String getCommentState() {
                return commentState;
            }

            public void setCommentState(String commentState) {
                this.commentState = commentState;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderState() {
                return orderState;
            }

            public void setOrderState(String orderState) {
                this.orderState = orderState;
            }
        }

        public static class OrderInfoBean {
            /**
             * id : 1061833135170445314
             * createBy : 127
             * createTime : 2018-11-12 12:08:42
             * modifyBy : null
             * modifyTime : null
             * code : 201811121061833135191416833
             * orderType : TIME_JOB_SHOW
             * province : 省
             * city : 市
             * area : 区
             * address : 街道地址
             * house : 房间号
             * linkman : 联系人
             * sex : 性别
             * phone : 手机号
             * longitude : 经度
             * latitude : 纬度
             * workBegin : 2018-10-11
             * workEnd : 2018-10-11
             * oneDayBegin : 14:18:24
             * oneDayEnd : 14:18:41
             * salary : 122
             * per : null
             * workerSalary : 97.6
             * depositSalary : 0
             * residueSalary : 0
             * describeText : 文字描述
             * files : null
             * orderTypeName : 商演
             */

            private String id;
            private String createBy;
            private String createTime;
            private Object modifyBy;
            private Object modifyTime;
            private String code;
            private String orderType;
            private String province;
            private String city;
            private String area;
            private String address;
            private String house;
            private String linkman;
            private String sex;
            private String phone;
            private String longitude;
            private String latitude;
            private String workBegin;
            private String workEnd;
            private String oneDayBegin;
            private String oneDayEnd;
            private int salary;
            private Object per;
            private double workerSalary;
            private int depositSalary;
            private int residueSalary;
            private String describeText;
            private Object files;
            private String orderTypeName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getModifyBy() {
                return modifyBy;
            }

            public void setModifyBy(Object modifyBy) {
                this.modifyBy = modifyBy;
            }

            public Object getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(Object modifyTime) {
                this.modifyTime = modifyTime;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getOrderType() {
                return orderType;
            }

            public void setOrderType(String orderType) {
                this.orderType = orderType;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getHouse() {
                return house;
            }

            public void setHouse(String house) {
                this.house = house;
            }

            public String getLinkman() {
                return linkman;
            }

            public void setLinkman(String linkman) {
                this.linkman = linkman;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getWorkBegin() {
                return workBegin;
            }

            public void setWorkBegin(String workBegin) {
                this.workBegin = workBegin;
            }

            public String getWorkEnd() {
                return workEnd;
            }

            public void setWorkEnd(String workEnd) {
                this.workEnd = workEnd;
            }

            public String getOneDayBegin() {
                return oneDayBegin;
            }

            public void setOneDayBegin(String oneDayBegin) {
                this.oneDayBegin = oneDayBegin;
            }

            public String getOneDayEnd() {
                return oneDayEnd;
            }

            public void setOneDayEnd(String oneDayEnd) {
                this.oneDayEnd = oneDayEnd;
            }

            public int getSalary() {
                return salary;
            }

            public void setSalary(int salary) {
                this.salary = salary;
            }

            public Object getPer() {
                return per;
            }

            public void setPer(Object per) {
                this.per = per;
            }

            public double getWorkerSalary() {
                return workerSalary;
            }

            public void setWorkerSalary(double workerSalary) {
                this.workerSalary = workerSalary;
            }

            public int getDepositSalary() {
                return depositSalary;
            }

            public void setDepositSalary(int depositSalary) {
                this.depositSalary = depositSalary;
            }

            public int getResidueSalary() {
                return residueSalary;
            }

            public void setResidueSalary(int residueSalary) {
                this.residueSalary = residueSalary;
            }

            public String getDescribeText() {
                return describeText;
            }

            public void setDescribeText(String describeText) {
                this.describeText = describeText;
            }

            public Object getFiles() {
                return files;
            }

            public void setFiles(Object files) {
                this.files = files;
            }

            public String getOrderTypeName() {
                return orderTypeName;
            }

            public void setOrderTypeName(String orderTypeName) {
                this.orderTypeName = orderTypeName;
            }
        }
    }
}
