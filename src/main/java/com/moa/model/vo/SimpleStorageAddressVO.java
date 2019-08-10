package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleStorageAddressVO {
    private int storageId;
    private String baseAddress;
    private String detailAddress;
}
