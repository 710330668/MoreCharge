package com.example.com.morecharge.release.response;

public class OrderTimeJobResponse {

    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : {"id":"1069431839484981250","createBy":"127","createTime":"2018-12-03 11:23:14","modifyBy":null,"modifyTime":null,"code":"201811301069431839484981251","orderType":"TIME_JOB_SHOW","province":"省","city":"市","area":"区","address":"街道地址","house":"房间号","linkman":"联系人","sex":"性别","phone":"手机号","longitude":"经度","latitude":"纬度","workBegin":"2018-10-11","workEnd":"2018-10-11","oneDayBegin":"14:18:24","oneDayEnd":"14:18:41","salary":122,"per":null,"workerSalary":97.6,"depositSalary":null,"residueSalary":null,"describeText":"文字描述","files":null,"orderTypeName":null}
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
         * id : 1069431839484981250
         * createBy : 127
         * createTime : 2018-12-03 11:23:14
         * modifyBy : null
         * modifyTime : null
         * code : 201811301069431839484981251
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
         * depositSalary : null
         * residueSalary : null
         * describeText : 文字描述
         * files : null
         * orderTypeName : null
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
        private Object depositSalary;
        private Object residueSalary;
        private String describeText;
        private Object files;
        private Object orderTypeName;

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

        public Object getDepositSalary() {
            return depositSalary;
        }

        public void setDepositSalary(Object depositSalary) {
            this.depositSalary = depositSalary;
        }

        public Object getResidueSalary() {
            return residueSalary;
        }

        public void setResidueSalary(Object residueSalary) {
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

        public Object getOrderTypeName() {
            return orderTypeName;
        }

        public void setOrderTypeName(Object orderTypeName) {
            this.orderTypeName = orderTypeName;
        }
    }
}
