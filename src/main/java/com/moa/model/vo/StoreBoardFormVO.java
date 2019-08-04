package com.moa.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class StoreBoardFormVO {
    private String hostId;
    private String transactionType;
    private String pet;
    private String cctv;
    private List<String> forbiddenCategoryList;
    private List<String> forbiddenProductList;
    private String storagePeriodType;
    private List<String> price;
    private List<String> pictureName;
    private String title;
    private String content;
    private int storageId;

    public StoreBoardFormVO() {	}

    public StoreBoardFormVO(String hostId, String transactionType, String pet, String cctv,
                            List<String> forbiddenCategoryList, List<String> forbiddenProductList, String storagePeriodType,
                            List<String> price, List<String> pictureName, String title, String content, int storageId) {
        super();
        this.hostId = hostId;
        this.transactionType = transactionType;
        this.pet = pet;
        this.cctv = cctv;
        this.forbiddenCategoryList = forbiddenCategoryList;
        this.forbiddenProductList = forbiddenProductList;
        this.storagePeriodType = storagePeriodType;
        this.price = price;
        this.pictureName = pictureName;
        this.title = title;
        this.content = content;
        this.storageId = storageId;
    }
}
