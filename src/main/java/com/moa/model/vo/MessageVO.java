package com.moa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Data
@Component
public class MessageVO {
    private int receiverId;
    private String receiverNick;
    private int senderId;
    private String senderNick;
    private String content;
    private int senderDelFlag;
    private int recipientDelFlag;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date sendDate;
    @JsonFormat(pattern="tt:mm:ss")
    private Time sendTime;
    private int messageId;
    private int readState;
}
