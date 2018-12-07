package com.example.hdd.morecharge.usercenter.response;

import java.util.List;

/**
 * Created by 71033 on 2018/12/4.
 */
public class MyReceiveOrdersResponse {


    /**
     * success : true
     * msg : 查询成功
     * code : 0
     * data : {"records":[{"orderInfo":{"id":"1053160652573749249","createBy":"138","createTime":"2018-10-19 13:47:31","modifyBy":"138","modifyTime":"2018-10-19 13:47:31","orderType":"BUILD_PROJECT_DIAN","orderTypeName":"电","code":"201810191053160692893593601","materialType":"Y","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区银丰·联荷广场","house":"1号楼22层","linkman":"包活先生","sex":"B","phone":"18211110022","longitude":"117.13656","latitude":"36.676389","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":1111,"workerSalary":888.8,"depositSalary":0,"residueSalary":0,"describeText":"描述AA","files":null},"workerInfo":{"commentState":"Y","orderState":"FINISH"}}],"total":"1","size":"10","current":"1","pages":"1"}
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
         * records : [{"orderInfo":{"id":"1053160652573749249","createBy":"138","createTime":"2018-10-19 13:47:31","modifyBy":"138","modifyTime":"2018-10-19 13:47:31","orderType":"BUILD_PROJECT_DIAN","orderTypeName":"电","code":"201810191053160692893593601","materialType":"Y","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区银丰·联荷广场","house":"1号楼22层","linkman":"包活先生","sex":"B","phone":"18211110022","longitude":"117.13656","latitude":"36.676389","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":1111,"workerSalary":888.8,"depositSalary":0,"residueSalary":0,"describeText":"描述AA","files":null},"workerInfo":{"commentState":"Y","orderState":"FINISH"}}]
         * total : 1
         * size : 10
         * current : 1
         * pages : 1
         */

        private String total;
        private String size;
        private String current;
        private String pages;
        private List<RecordsBean> records;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * orderInfo : {"id":"1053160652573749249","createBy":"138","createTime":"2018-10-19 13:47:31","modifyBy":"138","modifyTime":"2018-10-19 13:47:31","orderType":"BUILD_PROJECT_DIAN","orderTypeName":"电","code":"201810191053160692893593601","materialType":"Y","province":"370000","city":"0531","area":"370102","address":"山东省济南市历下区银丰·联荷广场","house":"1号楼22层","linkman":"包活先生","sex":"B","phone":"18211110022","longitude":"117.13656","latitude":"36.676389","workBegin":"2018-10-27","workEnd":"2018-10-27","salary":1111,"workerSalary":888.8,"depositSalary":0,"residueSalary":0,"describeText":"描述AA","files":null}
             * workerInfo : {"commentState":"Y","orderState":"FINISH"}
             */

            private OrderInfoBean orderInfo;
            private WorkerInfoBean workerInfo;

            public OrderInfoBean getOrderInfo() {
                return orderInfo;
            }

            public void setOrderInfo(OrderInfoBean orderInfo) {
                this.orderInfo = orderInfo;
            }

            public WorkerInfoBean getWorkerInfo() {
                return workerInfo;
            }

            public void setWorkerInfo(WorkerInfoBean workerInfo) {
                this.workerInfo = workerInfo;
            }

            public static class OrderInfoBean {
                /**
                 * id : 1053160652573749249
                 * createBy : 138
                 * createTime : 2018-10-19 13:47:31
                 * modifyBy : 138
                 * modifyTime : 2018-10-19 13:47:31
                 * orderType : BUILD_PROJECT_DIAN
                 * orderTypeName : 电
                 * code : 201810191053160692893593601
                 * materialType : Y
                 * province : 370000
                 * city : 0531
                 * area : 370102
                 * address : 山东省济南市历下区银丰·联荷广场
                 * house : 1号楼22层
                 * linkman : 包活先生
                 * sex : B
                 * phone : 18211110022
                 * longitude : 117.13656
                 * latitude : 36.676389
                 * workBegin : 2018-10-27
                 * workEnd : 2018-10-27
                 * salary : 1111
                 * workerSalary : 888.8
                 * depositSalary : 0
                 * residueSalary : 0
                 * describeText : 描述AA
                 * files : null
                 */

                private String id;
                private String createBy;
                private String createTime;
                private String modifyBy;
                private String modifyTime;
                private String orderType;
                private String orderTypeName;
                private String code;
                private String materialType;
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
                private double salary;
                private double workerSalary;
                private double depositSalary;
                private double residueSalary;
                private String describeText;
//                private Object files;

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

                public String getModifyBy() {
                    return modifyBy;
                }

                public void setModifyBy(String modifyBy) {
                    this.modifyBy = modifyBy;
                }

                public String getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(String modifyTime) {
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

                public String getMaterialType() {
                    return materialType;
                }

                public void setMaterialType(String materialType) {
                    this.materialType = materialType;
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

//                public Object getFiles() {
//                    return files;
//                }
//
//                public void setFiles(Object files) {
//                    this.files = files;
//                }
            }

            public static class WorkerInfoBean {
                /**
                 * commentState : Y
                 * orderState : FINISH
                 */

                private String commentState;
                private String orderState;

                public String getCommentState() {
                    return commentState;
                }

                public void setCommentState(String commentState) {
                    this.commentState = commentState;
                }

                public String getOrderState() {
                    return orderState;
                }

                public void setOrderState(String orderState) {
                    this.orderState = orderState;
                }
            }
        }
    }
}
