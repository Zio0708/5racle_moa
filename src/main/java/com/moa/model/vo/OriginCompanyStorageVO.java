package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginCompanyStorageVO {
    private int userId;
    private int addressId;
    private String businessName;
    private String representative;
    private String registrationNum;
}
