package com.moa.model.vo;

import lombok.Data;

@Data
public class HostReputationVO {
    private String nick;
    private double starPointAvg;
    private int favoriteCnt;
    private int totalReviewCnt;
}
