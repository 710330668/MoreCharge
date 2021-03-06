package com.example.hdd.morecharge.receive.main.integrate.entity;

import java.util.List;

public class IntegGoodsListResponse {


    /**
     * success : true
     * msg : 操作成功
     * code : 0
     * data : {"records":[{"id":"1065444535130267650","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"name":"新疆红枣","integral":100,"price":29.8,"onLine":"Y","sortNumber":0,"explainText":"好想你免洗即食红枣新疆阿克苏枣500g新疆特产灰枣","headImg":[{"id":"1065444535322954369","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣头像","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/e859eff8deb546369a29121e7f66900c.png","sortNumber":2,"businessFlag":"HEADIMG","remarks":"备注"}],"banners":[{"id":"1065444536687446786","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣bannerA","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/4817121769b94720918a4a1725078d5d.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"}],"information":[{"id":"1065444536687446711","createBy":null,"createTime":null,"modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣详情","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/feeacbb70f6a467aba18af806261d150.png","sortNumber":1,"businessFlag":"INFORMATION","remarks":null}]},{"id":"1065443875982884865","createBy":"127","createTime":"2018-11-22 11:16:30","modifyBy":null,"modifyTime":null,"name":"山核桃","integral":100,"price":95.9,"onLine":"Y","sortNumber":9,"explainText":"姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食。姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货20","headImg":[{"id":"1065444535360954369","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃头像","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/04baf0bb12704d02b83744a8431e1972.png","sortNumber":2,"businessFlag":"HEADIMG","remarks":"备注"}],"banners":[{"id":"1065444535587446786","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃bannerA","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/417248bcbbaa43e2bdefc728a77087e7.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"},{"id":"1065444535616806914","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃bannerB","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/417248bcbbaa43e2bdefc728a77087e7.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"}],"information":[{"id":"1065444535646167042","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃详情","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/420ce4ef7bed4dca8121e5fd754df11b.png","sortNumber":2,"businessFlag":"INFORMATION","remarks":"备注"}]}],"total":"2","size":"10","current":"1","pages":"1"}
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
         * records : [{"id":"1065444535130267650","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"name":"新疆红枣","integral":100,"price":29.8,"onLine":"Y","sortNumber":0,"explainText":"好想你免洗即食红枣新疆阿克苏枣500g新疆特产灰枣","headImg":[{"id":"1065444535322954369","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣头像","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/e859eff8deb546369a29121e7f66900c.png","sortNumber":2,"businessFlag":"HEADIMG","remarks":"备注"}],"banners":[{"id":"1065444536687446786","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣bannerA","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/4817121769b94720918a4a1725078d5d.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"}],"information":[{"id":"1065444536687446711","createBy":null,"createTime":null,"modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣详情","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/feeacbb70f6a467aba18af806261d150.png","sortNumber":1,"businessFlag":"INFORMATION","remarks":null}]},{"id":"1065443875982884865","createBy":"127","createTime":"2018-11-22 11:16:30","modifyBy":null,"modifyTime":null,"name":"山核桃","integral":100,"price":95.9,"onLine":"Y","sortNumber":9,"explainText":"姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食。姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货2018新核桃坚果零食 姚生记手剥山核桃500g杭州临安特产小核桃新货20","headImg":[{"id":"1065444535360954369","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃头像","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/04baf0bb12704d02b83744a8431e1972.png","sortNumber":2,"businessFlag":"HEADIMG","remarks":"备注"}],"banners":[{"id":"1065444535587446786","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃bannerA","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/417248bcbbaa43e2bdefc728a77087e7.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"},{"id":"1065444535616806914","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃bannerB","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/417248bcbbaa43e2bdefc728a77087e7.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"}],"information":[{"id":"1065444535646167042","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065443875982884865","fileName":"核桃详情","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/420ce4ef7bed4dca8121e5fd754df11b.png","sortNumber":2,"businessFlag":"INFORMATION","remarks":"备注"}]}]
         * total : 2
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
             * id : 1065444535130267650
             * createBy : 127
             * createTime : 2018-11-22 11:19:07
             * modifyBy : null
             * modifyTime : null
             * name : 新疆红枣
             * integral : 100
             * price : 29.8
             * onLine : Y
             * sortNumber : 0
             * explainText : 好想你免洗即食红枣新疆阿克苏枣500g新疆特产灰枣
             * headImg : [{"id":"1065444535322954369","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣头像","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/e859eff8deb546369a29121e7f66900c.png","sortNumber":2,"businessFlag":"HEADIMG","remarks":"备注"}]
             * banners : [{"id":"1065444536687446786","createBy":"127","createTime":"2018-11-22 11:19:07","modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣bannerA","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/4817121769b94720918a4a1725078d5d.png","sortNumber":2,"businessFlag":"BANNER","remarks":"备注"}]
             * information : [{"id":"1065444536687446711","createBy":null,"createTime":null,"modifyBy":null,"modifyTime":null,"orderId":"1065444535130267650","fileName":"大枣详情","fileKey":null,"fileUrl":"http://jcool.oss-cn-beijing.aliyuncs.com/feeacbb70f6a467aba18af806261d150.png","sortNumber":1,"businessFlag":"INFORMATION","remarks":null}]
             */

            private String id;
            private String createBy;
            private String createTime;
            private String modifyBy;
            private String modifyTime;
            private String name;
            private int integral;
            private double price;
            private String onLine;
            private int sortNumber;
            private String explainText;
            private List<HeadImgBean> headImg;
            private List<BannersBean> banners;
            private List<InformationBean> information;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getOnLine() {
                return onLine;
            }

            public void setOnLine(String onLine) {
                this.onLine = onLine;
            }

            public int getSortNumber() {
                return sortNumber;
            }

            public void setSortNumber(int sortNumber) {
                this.sortNumber = sortNumber;
            }

            public String getExplainText() {
                return explainText;
            }

            public void setExplainText(String explainText) {
                this.explainText = explainText;
            }

            public List<HeadImgBean> getHeadImg() {
                return headImg;
            }

            public void setHeadImg(List<HeadImgBean> headImg) {
                this.headImg = headImg;
            }

            public List<BannersBean> getBanners() {
                return banners;
            }

            public void setBanners(List<BannersBean> banners) {
                this.banners = banners;
            }

            public List<InformationBean> getInformation() {
                return information;
            }

            public void setInformation(List<InformationBean> information) {
                this.information = information;
            }

            public static class HeadImgBean {
                /**
                 * id : 1065444535322954369
                 * createBy : 127
                 * createTime : 2018-11-22 11:19:07
                 * modifyBy : null
                 * modifyTime : null
                 * orderId : 1065444535130267650
                 * fileName : 大枣头像
                 * fileKey : null
                 * fileUrl : http://jcool.oss-cn-beijing.aliyuncs.com/e859eff8deb546369a29121e7f66900c.png
                 * sortNumber : 2
                 * businessFlag : HEADIMG
                 * remarks : 备注
                 */

                private String id;
                private String createBy;
                private String createTime;
                private String modifyBy;
                private String modifyTime;
                private String orderId;
                private String fileName;
                private String fileKey;
                private String fileUrl;
                private int sortNumber;
                private String businessFlag;
                private String remarks;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

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

                public int getSortNumber() {
                    return sortNumber;
                }

                public void setSortNumber(int sortNumber) {
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

            public static class BannersBean {
                /**
                 * id : 1065444536687446786
                 * createBy : 127
                 * createTime : 2018-11-22 11:19:07
                 * modifyBy : null
                 * modifyTime : null
                 * orderId : 1065444535130267650
                 * fileName : 大枣bannerA
                 * fileKey : null
                 * fileUrl : http://jcool.oss-cn-beijing.aliyuncs.com/4817121769b94720918a4a1725078d5d.png
                 * sortNumber : 2
                 * businessFlag : BANNER
                 * remarks : 备注
                 */

                private String id;
                private String createBy;
                private String createTime;
                private String modifyBy;
                private String modifyTime;
                private String orderId;
                private String fileName;
                private String fileKey;
                private String fileUrl;
                private int sortNumber;
                private String businessFlag;
                private String remarks;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

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

                public int getSortNumber() {
                    return sortNumber;
                }

                public void setSortNumber(int sortNumber) {
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

            public static class InformationBean {
                /**
                 * id : 1065444536687446711
                 * createBy : null
                 * createTime : null
                 * modifyBy : null
                 * modifyTime : null
                 * orderId : 1065444535130267650
                 * fileName : 大枣详情
                 * fileKey : null
                 * fileUrl : http://jcool.oss-cn-beijing.aliyuncs.com/feeacbb70f6a467aba18af806261d150.png
                 * sortNumber : 1
                 * businessFlag : INFORMATION
                 * remarks : null
                 */

                private String id;
                private String createBy;
                private String createTime;
                private String modifyBy;
                private String modifyTime;
                private String orderId;
                private String fileName;
                private String fileKey;
                private String fileUrl;
                private int sortNumber;
                private String businessFlag;
                private String remarks;

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

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

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

                public int getSortNumber() {
                    return sortNumber;
                }

                public void setSortNumber(int sortNumber) {
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
    }
}
