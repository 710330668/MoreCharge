package com.example.com.morecharge.release.request;

import java.util.List;

public class OrderCleanupRequest {

    /**
     * province : 省
     * city : 市
     * area : 区
     * address : 街道地址
     * house : 房间号
     * longitude : 经度
     * latitude : 纬度
     * linkman : 联系人
     * sex : 性别
     * phone : 手机号
     * orderType : 订单类型
     * numberOfPeople : 人数
     * workEnd : 2018-10-11
     * salary : 122
     * describeText : 文字描述
     * files : [{"fileName":"文件名称","fileKey":"第三方fileKey","fileUrl":"第三方fileUrl","sortNumber":"2","businessFlag":"xxx","remarks":"备注"},{"fileName":"文件名称","fileKey":"第三方fileKey","fileUrl":"第三方fileUrl","sortNumber":"2","businessFlag":"xxx","remarks":"备注"}]
     */

    private String province;
    private String city;
    private String area;
    private String address;
    private String house;
    private String longitude;
    private String latitude;
    private String linkman;
    private String sex;
    private String phone;
    private String orderType;
    private String numberOfPeople;
    private String workEnd;
    private String salary;
    private String describeText;
    private List<FilesBean> files;

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public List<FilesBean> getFiles() {
        return files;
    }

    public void setFiles(List<FilesBean> files) {
        this.files = files;
    }

    public static class FilesBean {
        /**
         * fileName : 文件名称
         * fileKey : 第三方fileKey
         * fileUrl : 第三方fileUrl
         * sortNumber : 2
         * businessFlag : xxx
         * remarks : 备注
         */

        private String fileName;
        private String fileKey;
        private String fileUrl;
        private String sortNumber;
        private String businessFlag;
        private String remarks;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileKey() {
            return fileKey;
        }

        public void setFileKey(String fileKey) {
            this.fileKey = fileKey;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getSortNumber() {
            return sortNumber;
        }

        public void setSortNumber(String sortNumber) {
            this.sortNumber = sortNumber;
        }

        public String getBusinessFlag() {
            return businessFlag;
        }

        public void setBusinessFlag(String businessFlag) {
            this.businessFlag = businessFlag;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }
}
