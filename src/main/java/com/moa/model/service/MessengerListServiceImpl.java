package com.moa.model.service;

import com.moa.model.dao.MessengerDAOImpl;
import com.moa.model.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessengerListServiceImpl {
    @Autowired
    private MessengerDAOImpl dao;

    public List<MessageVO>  messageList(Map<String,Object> messageInfo){
        return dao.searchMessage(messageInfo);
    }
    public int messageListCnt(Map<String,Object> messageInfo){
        return dao.searchAllMessageCnt(messageInfo);
    }
    public boolean messageDelete(Map<String,Object> messageInfo){
        return dao.deleteMessage(messageInfo);
    }
    public boolean messageRead(int messageNum){
        return dao.updateReadState(messageNum);
    }
    public MessageVO messageDetail(int messageId){
        return dao.searchOneMessage(messageId);
    }
    public boolean messageSend(Map<String,Object> sentMessage){
        return dao.insertOneMessage(sentMessage);
    }
}
