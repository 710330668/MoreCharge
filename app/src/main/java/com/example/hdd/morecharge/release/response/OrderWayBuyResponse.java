package com.example.com.morecharge.release.response;

public class OrderWayBuyResponse {

    /**
     * success : true
     * msg : 发单成功，可以到我的订单列表中查看
     * code : 0
     * data : {"id":"1069417441081077763","createBy":"127","createTime":"2018-12-03 10:26:01","modifyBy":null,"modifyTime":null,"code":"201811301069417441081077762","orderType":"WAY_BUY","orderTypeName":null,"province":"山东","city":"青岛","area":"李沧区","address":"订单详细地址","house":"齐盛大厦1号楼","linkman":"李四","sex":"B","phone":"17688889999","longitude":"117.070803","latitude":"36.666502","goodsName":"景田矿泉水","buyType":"APOINT,\t\tARBITRARY","buyAddress":"家乐福超市","receivingTime":null,"salary":19.5,"workerSalary":15.6,"depositSalary":null,"residueSalary":null,"describeText":"这是我的描述"}
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
         * id : 1069417441081077763
         * createBy : 127
         * createTime : 2018-12-03 10:26:01
         * modifyBy : null
         * modifyTime : null
         * code : 201811301069417441081077762
         * orderType : WAY_BUY
         * orderTypeName : null
         * province : 山东
         * city : 青岛
         * area : 李沧区
         * address : 订单详细地址
         * house : 齐盛大厦1号楼
         * linkman : 李四
         * sex : B
         * phone : 17688889999
         * longitude : 117.070803
         * latitude : 36.666502
         * goodsName : 景田矿泉水
         * buyType : APOINT,		ARBITRARY
         * buyAddress : 家乐福超市
         * receivingTime : null
         * salary : 19.5
         * workerSalary : 15.6
         * depositSalary : null
         * residueSalary : null
         * describeText : 这是我的描述
         */

        private String id;
        private String createBy;
        private String createTime;
        private Object modifyBy;
        private Object modifyTime;
        private String code;
        private String orderType;
        private Object orderTypeName;
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
        private String goodsName;
        private String buyType;
        private String buyAddress;
        private Object receivingTime;
        private double salary;
        private double workerSalary;
        private Object depositSalary;
        private Object residueSalary;
        private String describeText;

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

        public Object getOrderTypeName() {
            return orderTypeName;
        }

        public void setOrderTypeName(Object orderTypeName) {
            this.orderTypeName = orderTypeName;
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

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getBuyType() {
            return buyType;
        }

        public void setBuyType(String buyType) {
            this.buyType = buyType;
        }

        public String getBuyAddress() {
            return buyAddress;
        }

        public void setBuyAddress(String buyAddress) {
            this.buyAddress = buyAddress;
        }

        public Object getReceivingTime() {
            return receivingTime;
        }

        public void setReceivingTime(Object receivingTime) {
            this.receivingTime = receivingTime;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
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
    }
}
