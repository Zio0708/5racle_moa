package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOtherStorageVO {
    private double longitude;
    private double latitude;
    private String postCode;
    private String baseAddress;
    private String detailAddress;
    private int userId;
    private String otherText;

}
