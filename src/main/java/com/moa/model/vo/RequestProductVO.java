package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestProductVO {
    private String productName;
    private int productCnt;
    private String productCategory;

}
