package com.moa.mybatis;

import com.moa.model.vo.MessageVO;

import java.util.List;
import java.util.Map;

public interface MessengerMapper {
    List<MessageVO> searchMessage(Map<String, Object> messageInfo);
    int searchAllMessageCnt(Map<String, Object> messageinfo);
    boolean updateReadState(int messageNum);
    boolean deleteMessage(Map<String, Object> messageInfo);
    MessageVO searchOneMessage(int messageId);
    boolean insertOneMessage(Map<String,Object> insertMessageInfo);
}
