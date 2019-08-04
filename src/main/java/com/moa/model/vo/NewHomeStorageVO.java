package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewHomeStorageVO {
    private double longitude;
    private double latitude;
    private String postCode;
    private String baseAddress;
    private String detailAddress;
    private int userId;
}
