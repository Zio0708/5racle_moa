package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewCompanyStorageVO {
    private double longitude;
    private double latitude;
    private String postCode;
    private String baseAddress;
    private String detailAddress;
    private int userId;
    private String businessName;
    private String representative;
    private String registrationNum;

}
