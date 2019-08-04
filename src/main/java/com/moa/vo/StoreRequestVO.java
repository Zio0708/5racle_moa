package com.moa.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class StoreRequestVO {
    private int storeRequestNum;
    private int articleNum;
    private int userId;
    private int measuredPrice;
    private int bargainPrice;
    private Date startDate;
    private Date endDate;
    private String transactionWay;
    private String content;

    private String productCnt;
    private String productSize;
    private String category;
    private String product;
    private String pictureName;

    public StoreRequestVO() {
    }

    public StoreRequestVO(int articleNum, int userId, int measuredPrice, int bargainPrice, Date startDate, Date endDate, String transactionWay, String content, String productCnt, String productSize, String category, String product, String pictureName) {
        this.articleNum = articleNum;
        this.userId = userId;
        this.measuredPrice = measuredPrice;
        this.bargainPrice = bargainPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactionWay = transactionWay;
        this.content = content;
        this.productCnt = productCnt;
        this.productSize = productSize;
        this.category = category;
        this.product = product;
        this.pictureName = pictureName;
    }
}
