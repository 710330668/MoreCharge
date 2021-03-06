package com.example.com.morecharge.release.response;

public class OrderWayExpressResponse {

    /**
     * success : true
     * msg : 发单成功，可以到我的订单列表中查看
     * code : 0
     * data : {"id":"1069423027046756355","createBy":"127","createTime":"2018-12-03 10:48:13","modifyBy":null,"modifyTime":null,"code":"201811301069423027046756354","orderType":"WAY_EXPRESS","orderTypeName":null,"fromProvince":"取件省","fromCity":"取件市","fromArea":"取件区","fromAddress":"取件详细地址","fromHouse":"取件详细地址","fromLongitude":"123","fromLatitude":"123","fromLinkman":"取件联系人","fromSex":"取件人性别","fromPhone":"取件人电话","toProvince":"到达省","toCity":"到达市","toArea":"到达区","toAddress":"到达详地址","toHouse":"取件详细地址","toLinkman":"收件件联系人","toSex":"收件人性别","toPhone":"收件人电话","toLongitude":"123","toLatitude":"123","getGoodsTime":"2018-09-28 13:54:21","goodsType":"物品类型","goodsWeight":15,"insuranceType":"保险类型","describeText":"描述","salary":19.5,"workerSalary":15.6,"depositSalary":null,"residueSalary":null}
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
         * id : 1069423027046756355
         * createBy : 127
         * createTime : 2018-12-03 10:48:13
         * modifyBy : null
         * modifyTime : null
         * code : 201811301069423027046756354
         * orderType : WAY_EXPRESS
         * orderTypeName : null
         * fromProvince : 取件省
         * fromCity : 取件市
         * fromArea : 取件区
         * fromAddress : 取件详细地址
         * fromHouse : 取件详细地址
         * fromLongitude : 123
         * fromLatitude : 123
         * fromLinkman : 取件联系人
         * fromSex : 取件人性别
         * fromPhone : 取件人电话
         * toProvince : 到达省
         * toCity : 到达市
         * toArea : 到达区
         * toAddress : 到达详地址
         * toHouse : 取件详细地址
         * toLinkman : 收件件联系人
         * toSex : 收件人性别
         * toPhone : 收件人电话
         * toLongitude : 123
         * toLatitude : 123
         * getGoodsTime : 2018-09-28 13:54:21
         * goodsType : 物品类型
         * goodsWeight : 15
         * insuranceType : 保险类型
         * describeText : 描述
         * salary : 19.5
         * workerSalary : 15.6
         * depositSalary : null
         * residueSalary : null
         */

        private String id;
        private String createBy;
        private String createTime;
        private Object modifyBy;
        private Object modifyTime;
        private String code;
        private String orderType;
        private Object orderTypeName;
        private String fromProvince;
        private String fromCity;
        private String fromArea;
        private String fromAddress;
        private String fromHouse;
        private String fromLongitude;
        private String fromLatitude;
        private String fromLinkman;
        private String fromSex;
        private String fromPhone;
        private String toProvince;
        private String toCity;
        private String toArea;
        private String toAddress;
        private String toHouse;
        private String toLinkman;
        private String toSex;
        private String toPhone;
        private String toLongitude;
        private String toLatitude;
        private String getGoodsTime;
        private String goodsType;
        private int goodsWeight;
        private String insuranceType;
        private String describeText;
        private double salary;
        private double workerSalary;
        private Object depositSalary;
        private Object residueSalary;

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

        public String getFromProvince() {
            return fromProvince;
        }

        public void setFromProvince(String fromProvince) {
            this.fromProvince = fromProvince;
        }

        public String getFromCity() {
            return fromCity;
        }

        public void setFromCity(String fromCity) {
            this.fromCity = fromCity;
        }

        public String getFromArea() {
            return fromArea;
        }

        public void setFromArea(String fromArea) {
            this.fromArea = fromArea;
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        public String getFromHouse() {
            return fromHouse;
        }

        public void setFromHouse(String fromHouse) {
            this.fromHouse = fromHouse;
        }

        public String getFromLongitude() {
            return fromLongitude;
        }

        public void setFromLongitude(String fromLongitude) {
            this.fromLongitude = fromLongitude;
        }

        public String getFromLatitude() {
            return fromLatitude;
        }

        public void setFromLatitude(String fromLatitude) {
            this.fromLatitude = fromLatitude;
        }

        public String getFromLinkman() {
            return fromLinkman;
        }

        public void setFromLinkman(String fromLinkman) {
            this.fromLinkman = fromLinkman;
        }

        public String getFromSex() {
            return fromSex;
        }

        public void setFromSex(String fromSex) {
            this.fromSex = fromSex;
        }

        public String getFromPhone() {
            return fromPhone;
        }

        public void setFromPhone(String fromPhone) {
            this.fromPhone = fromPhone;
        }

        public String getToProvince() {
            return toProvince;
        }

        public void setToProvince(String toProvince) {
            this.toProvince = toProvince;
        }

        public String getToCity() {
            return toCity;
        }

        public void setToCity(String toCity) {
            this.toCity = toCity;
        }

        public String getToArea() {
            return toArea;
        }

        public void setToArea(String toArea) {
            this.toArea = toArea;
        }

        public String getToAddress() {
            return toAddress;
        }

        public void setToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        public String getToHouse() {
            return toHouse;
        }

        public void setToHouse(String toHouse) {
            this.toHouse = toHouse;
        }

        public String getToLinkman() {
            return toLinkman;
        }

        public void setToLinkman(String toLinkman) {
            this.toLinkman = toLinkman;
        }

        public String getToSex() {
            return toSex;
        }

        public void setToSex(String toSex) {
            this.toSex = toSex;
        }

        public String getToPhone() {
            return toPhone;
        }

        public void setToPhone(String toPhone) {
            this.toPhone = toPhone;
        }

        public String getToLongitude() {
            return toLongitude;
        }

        public void setToLongitude(String toLongitude) {
            this.toLongitude = toLongitude;
        }

        public String getToLatitude() {
            return toLatitude;
        }

        public void setToLatitude(String toLatitude) {
            this.toLatitude = toLatitude;
        }

        public String getGetGoodsTime() {
            return getGoodsTime;
        }

        public void setGetGoodsTime(String getGoodsTime) {
            this.getGoodsTime = getGoodsTime;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public int getGoodsWeight() {
            return goodsWeight;
        }

        public void setGoodsWeight(int goodsWeight) {
            this.goodsWeight = goodsWeight;
        }

        public String getInsuranceType() {
            return insuranceType;
        }

        public void setInsuranceType(String insuranceType) {
            this.insuranceType = insuranceType;
        }

        public String getDescribeText() {
            return describeText;
        }

        public void setDescribeText(String describeText) {
            this.describeText = describeText;
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
    }
}
