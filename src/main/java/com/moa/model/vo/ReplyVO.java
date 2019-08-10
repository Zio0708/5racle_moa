package com.moa.model.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private String comment;
    private int rating;
    private int articleNum;
    private int parentNum;
    private int userId;

    @Override
    public String toString() {
        return "ReplyVO{" +
                "comment='" + comment + '\'' +
                ", rating=" + rating +
                ", articleNum=" + articleNum +
                ", parentNum=" + parentNum +
                ", userId=" + userId +
                '}';
    }
}
