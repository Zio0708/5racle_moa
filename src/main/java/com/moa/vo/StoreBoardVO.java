package com.moa.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StoreBoardVO {
    private int articleNum;
    private String title;
    private String content;
    private String writeDate;
    private String transactionType;
    private String storageType;
    private String storagePeriodType;
    private String baseAddress;
    private String detailAddress;
    private String forbiddenProduct;
    private String securityFacility;
    private String pet;
    private List<String> pictureName;
    private Map<String,Integer> detailPrice;
}
