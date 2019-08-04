package com.moa.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginOtherStorageVO {
    private int userId;
    private int addressId;
    private String otherText;
}
