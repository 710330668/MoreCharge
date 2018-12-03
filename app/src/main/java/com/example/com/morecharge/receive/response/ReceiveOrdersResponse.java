package com.example.com.morecharge.receive.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 71033 on 2018/11/30.
 */
public class ReceiveOrdersResponse {


    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : [{"orderType":"BUILD_PERSON_MU","distance":5785.167530314558,"orderId":"1056001183498625025","orderInfo":{"id":"1056001183498625025","createBy":"140","createTime":"2018-10-27 09:54:36","modifyBy":null,"modifyTime":null,"orderType":"BUILD_PERSON_MU","orderTypeName":"木工","code":"201810271056001183515402241","skillGrade":"Z","numberOfPeople":8,"province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区同缘商务大厦","house":"18号楼88室","linkman":"林先生","sex":"B","phone":"18200001188","longitude":"117.133805","latitude":"36.678888","workBegin":"2019-10-27","workEnd":"2019-10-27","workDays":null,"oneDayBegin":"06:54:00","oneDayEnd":"15:54:00","oneDayWorks":null,"salary":1,"workerSalary":0.8,"depositSalary":5,"residueSalary":5,"describeText":"具体描述非淡泊无以明志非宁静无以致远","files":null}},{"orderType":"BUILD_PROJECT_SHUI","distance":5816.918093185599,"orderId":"1055024599467798529","orderInfo":{"id":"1055024599467798529","createBy":"138","createTime":"2018-10-24 17:14:10","modifyBy":"138","modifyTime":"2018-10-24 17:14:10","orderType":"BUILD_PROJECT_SHUI","orderTypeName":"水","code":"201810241055024637975703553","materialType":"N","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区普利广场停车场","house":"15号楼115室","linkman":"李先生","sex":"B","phone":"15100001155","longitude":"117.135504","latitude":"36.659947","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":1155,"workerSalary":924,"depositSalary":0,"residueSalary":0,"describeText":"具体描述山一程水一程身向榆关那畔行风一更学一更聒碎乡心梦不成故园","files":null}},{"orderType":"WAY_BUY","distance":5823.798810791349,"orderId":"1059290167138013186","orderInfo":{"id":"1059290167138013186","createBy":"1058564728953028609","createTime":"2018-11-05 11:43:51","modifyBy":null,"modifyTime":null,"code":"20181151059290167138013185","orderType":"WAY_BUY","orderTypeName":"代购","province":"山东省","city":"济南市","area":"历下区","address":"三庆·齐盛广场(济南市历下区)","house":"用户","linkman":"纪检部","sex":"B","phone":"15844","longitude":"117.1348","latitude":"36.67691","goodsName":"该喝喝非常差","buyType":"APOINT,ARBITRARY","buyAddress":null,"receivingTime":"2018-11-07 11:48:00","salary":1,"workerSalary":0.8,"depositSalary":500,"residueSalary":500,"describeText":null}},{"orderType":"BUILD_PERSON_XIAO","distance":5966.791480942318,"orderId":"1055751381590355970","orderInfo":{"id":"1055751381590355970","createBy":"140","createTime":"2018-10-26 17:21:59","modifyBy":null,"modifyTime":null,"orderType":"BUILD_PERSON_XIAO","orderTypeName":"小工","code":"201810261055751381590355971","skillGrade":"Z","numberOfPeople":4,"province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区银丰·联荷广场","house":"11号","linkman":"铅笔","sex":"B","phone":"18033334444","longitude":"117.13656","latitude":"36.676389","workBegin":"2020-10-26","workEnd":"2021-08-26","workDays":null,"oneDayBegin":"17:22:00","oneDayEnd":"21:22:00","oneDayWorks":null,"salary":1,"workerSalary":0.8,"depositSalary":4,"residueSalary":4,"describeText":"具体描述","files":null}},{"orderType":"BUILD_PROJECT_SHUI","distance":5991.85343709225,"orderId":"1055730685443268609","orderInfo":{"id":"1055730685443268609","createBy":"140","createTime":"2018-10-26 15:59:45","modifyBy":null,"modifyTime":null,"orderType":"BUILD_PROJECT_SHUI","orderTypeName":"水","code":"201810261055730685736869889","materialType":"N","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区分邦电商孵化基地","house":"11号楼","linkman":"嗯呢","sex":"B","phone":"18244441111","longitude":"117.136811","latitude":"36.676538","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":12,"workerSalary":9.6,"depositSalary":0.02,"residueSalary":0.02,"describeText":"具体描述，安全信息书具体年股市我说434664gmgmpmpmp是世界级的","files":null}},{"orderType":"BUILD_PERSON_MU","distance":6090.340032517435,"orderId":"1055032645698957314","orderInfo":{"id":"1055032645698957314","createBy":"138","createTime":"2018-10-24 17:45:59","modifyBy":"138","modifyTime":"2018-10-24 17:45:59","orderType":"BUILD_PERSON_MU","orderTypeName":"木工","code":"201810241055032645698957315","skillGrade":"Z","numberOfPeople":66,"province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区龙奥公交枢纽(公交站)","house":"11号66室","linkman":"李小姐","sex":"G","phone":"15100001166","longitude":"117.137306","latitude":"36.654095","workBegin":"2018-10-24","workEnd":"2019-12-12","workDays":null,"oneDayBegin":"08:43:00","oneDayEnd":"18:43:00","oneDayWorks":null,"salary":166,"workerSalary":132.8,"depositSalary":0,"residueSalary":0,"describeText":"具体描述何当共剪西窗烛却话巴山夜雨时庄生晓梦迷蝴蝶望帝春心托杜鹃蓝田日暖玉生烟","files":null}},{"orderType":"BUILD_PROJECT_DIAN","distance":6126.183242072083,"orderId":"1054911975040192514","orderInfo":{"id":"1054911975040192514","createBy":"138","createTime":"2018-10-24 09:46:49","modifyBy":"138","modifyTime":"2018-10-24 09:46:49","orderType":"BUILD_PROJECT_DIAN","orderTypeName":"电","code":"201810231054912058594922498","materialType":"N","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区中国电信山东分公司停车场","house":"5号楼101室","linkman":"二十四","sex":"G","phone":"15011110000","longitude":"117.139143","latitude":"36.661005","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":100,"workerSalary":80,"depositSalary":0,"residueSalary":0,"describeText":"具体描述云中谁寄锦书来，雁字回事月满西沟挣渡正度误入藕花深处","files":null}}]
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

    public static class DataBean implements Serializable{
        /**
         * orderType : BUILD_PERSON_MU
         * distance : 5785.167530314558
         * orderId : 1056001183498625025
         * orderInfo : {"id":"1056001183498625025","createBy":"140","createTime":"2018-10-27 09:54:36","modifyBy":null,"modifyTime":null,"orderType":"BUILD_PERSON_MU","orderTypeName":"木工","code":"201810271056001183515402241","skillGrade":"Z","numberOfPeople":8,"province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区同缘商务大厦","house":"18号楼88室","linkman":"林先生","sex":"B","phone":"18200001188","longitude":"117.133805","latitude":"36.678888","workBegin":"2019-10-27","workEnd":"2019-10-27","workDays":null,"oneDayBegin":"06:54:00","oneDayEnd":"15:54:00","oneDayWorks":null,"salary":1,"workerSalary":0.8,"depositSalary":5,"residueSalary":5,"describeText":"具体描述非淡泊无以明志非宁静无以致远","files":null}
         */

        private String orderType;
        private double distance;
        private String orderId;
        private OrderInfoBean orderInfo;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public OrderInfoBean getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfoBean orderInfo) {
            this.orderInfo = orderInfo;
        }

        public static class OrderInfoBean {
            /**
             * id : 1056001183498625025
             * createBy : 140
             * createTime : 2018-10-27 09:54:36
             * modifyBy : null
             * modifyTime : null
             * orderType : BUILD_PERSON_MU
             * orderTypeName : 木工
             * code : 201810271056001183515402241
             * skillGrade : Z
             * numberOfPeople : 8
             * province : 370000
             * city : 0531
             * area : 370102
             * address : 山东省济南市历下区同缘商务大厦
             * house : 18号楼88室
             * linkman : 林先生
             * sex : B
             * phone : 18200001188
             * longitude : 117.133805
             * latitude : 36.678888
             * workBegin : 2019-10-27
             * workEnd : 2019-10-27
             * workDays : null
             * oneDayBegin : 06:54:00
             * oneDayEnd : 15:54:00
             * oneDayWorks : null
             * salary : 1.0
             * workerSalary : 0.8
             * depositSalary : 5.0
             * residueSalary : 5.0
             * describeText : 具体描述非淡泊无以明志非宁静无以致远
             * files : null
             */

            private String id;
            private String createBy;
            private String createTime;
            private Object modifyBy;
            private Object modifyTime;
            private String orderType;
            private String orderTypeName;
            private String code;
            private String skillGrade;
            private int numberOfPeople;
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
            private Object workDays;
            private String oneDayBegin;
            private String oneDayEnd;
            private Object oneDayWorks;
            private double salary;
            private double workerSalary;
            private double depositSalary;
            private double residueSalary;
            private String describeText;
            private Object files;

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

            public String getOrderType() {
                return orderType;
            }

            public void setOrderType(String orderType) {
                this.orderType = orderType;
            }

            public String getOrderTypeName() {
                return orderTypeName;
            }

            public void setOrderTypeName(String orderTypeName) {
                this.orderTypeName = orderTypeName;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSkillGrade() {
                return skillGrade;
            }

            public void setSkillGrade(String skillGrade) {
                this.skillGrade = skillGrade;
            }

            public int getNumberOfPeople() {
                return numberOfPeople;
            }

            public void setNumberOfPeople(int numberOfPeople) {
                this.numberOfPeople = numberOfPeople;
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

            public Object getWorkDays() {
                return workDays;
            }

            public void setWorkDays(Object workDays) {
                this.workDays = workDays;
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

            public Object getOneDayWorks() {
                return oneDayWorks;
            }

            public void setOneDayWorks(Object oneDayWorks) {
                this.oneDayWorks = oneDayWorks;
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

            public double getDepositSalary() {
                return depositSalary;
            }

            public void setDepositSalary(double depositSalary) {
                this.depositSalary = depositSalary;
            }

            public double getResidueSalary() {
                return residueSalary;
            }

            public void setResidueSalary(double residueSalary) {
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
        }
    }
}
