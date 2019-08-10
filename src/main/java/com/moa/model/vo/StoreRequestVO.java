package com.moa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequestVO {
    @NotBlank
    private int storeRequestNum;
    @NotBlank
    private int articleNum;
    @NotBlank
    private int userId;
    @NotBlank
    private int measuredPrice;
    @NotBlank
    private int bargainPrice;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;
    @NotBlank
    private String transactionWay;
    @NotBlank
    @Max(1000)
    @Min(1)
    private String content;
    @NotBlank
    @Min(0)
    @Max(99)
    private String productCnt;
    @NotBlank
    private String productSize;
    @NotBlank
    @Min(1)
    @Max(20)
    private String category;
    @NotBlank
    @Min(1)
    @Max(50)
    private String product;
    @NotBlank
    @Min(1)
    @Max(260)
    private String pictureName;

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
