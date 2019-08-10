package com.moa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewVO {
    private int level;
    private int articleNO;
    private int parentNO;
    private int boardNO;
    private int starPoint;
    private String content;
    private String profile;
    private String nick;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date writeDate;
}
