package com.moa.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserInfoVO {
    private String profileName;
    private String name;
    private String email;
    private int requestCnt;
    private int notReadMessageCnt;
    private int usingStorageCnt;

}
