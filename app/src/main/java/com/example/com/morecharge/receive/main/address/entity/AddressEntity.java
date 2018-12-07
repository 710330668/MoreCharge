package com.example.com.morecharge.receive.main.address.entity;

import java.util.List;

public class AddressEntity {
    /**
     * success : true
     * msg : null
     * code : 0
     * data : [{"id":"1066144354646667266","userId":"127","userName":"林女士","telNumber":"15211133333","postalCode":"","nationalCode":"0","provinceName":"山东省","cityName":"济南市","countyName":"历下区","detailInfo":"中国电信山东分公司停车场2号楼","isDefault":0,"latitude":"36.661005","longitude":"117.139143","number":"1号楼203室"},{"id":"1066145839891648513","userId":"127","userName":"陈先生","telNumber":"15022214444","postalCode":"","nationalCode":"0","provinceName":"山东省","cityName":"济南市","countyName":"历下区","detailInfo":"碧桂园凤凰中心","isDefault":0,"latitude":"36.657802","longitude":"117.133574","number":"1号楼101室"},{"id":"1066966724114415618","userId":"127","userName":"林先生","telNumber":"15211110000","postalCode":"","nationalCode":"0","provinceName":"山东省","cityName":"济南市","countyName":"历下区","detailInfo":"海信·龙奥九号","isDefault":0,"latitude":"36.654761","longitude":"117.137012","number":"11号楼23室"},{"id":"1067326757465559041","userId":"127","userName":"dsfdsf","telNumber":"55565","postalCode":"","nationalCode":"0","provinceName":"0","cityName":"0","countyName":"0","detailInfo":"dsfdfsd","isDefault":1,"latitude":null,"longitude":null,"number":null}]
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
         * id : 1066144354646667266
         * userId : 127
         * userName : 林女士
         * telNumber : 15211133333
         * postalCode :
         * nationalCode : 0
         * provinceName : 山东省
         * cityName : 济南市
         * countyName : 历下区
         * detailInfo : 中国电信山东分公司停车场2号楼
         * isDefault : 0
         * latitude : 36.661005
         * longitude : 117.139143
         * number : 1号楼203室
         */

        private String id;
        private String userId;
        private String userName;
        private String telNumber;
        private String postalCode;
        private String nationalCode;
        private String provinceName;
        private String cityName;
        private String countyName;
        private String detailInfo;
        private int isDefault;
        private String latitude;
        private String longitude;
        private String number;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getTelNumber() {
            return telNumber;
        }

        public void setTelNumber(String telNumber) {
            this.telNumber = telNumber;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getNationalCode() {
            return nationalCode;
        }

        public void setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCountyName() {
            return countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        public String getDetailInfo() {
            return detailInfo;
        }

        public void setDetailInfo(String detailInfo) {
            this.detailInfo = detailInfo;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }


//    private String title;
//    private int holderType;
//
//
//    public AddressEntity() {
//    }
//
//    public AddressEntity(String title, int holderType) {
//        this.title = title;
//        this.holderType = holderType;
//    }
//
//    public int getHolderType() {
//        return holderType;
//    }
//
//    public void setHolderType(int holderType) {
//        this.holderType = holderType;
//    }
//
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

}
