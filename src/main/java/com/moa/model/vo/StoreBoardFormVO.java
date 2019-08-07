package com.moa.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class StoreBoardFormVO {
    @NotBlank
    private String hostId;
    @NotBlank
    private String transactionType;
    private String pet;
    @NotBlank
    private String cctv;
    @NotBlank
    private List<String> forbiddenCategoryList;
    @NotBlank
    private List<String> forbiddenProductList;
    @NotBlank
    private String storagePeriodType;
    @NotBlank
    private List<String> price;
    @NotBlank
    private List<String> pictureName;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
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
