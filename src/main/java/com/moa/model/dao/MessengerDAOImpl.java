package com.moa.model.dao;

import com.moa.model.vo.MessageVO;
import com.moa.mybatis.MessengerMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MessengerDAOImpl {
    @Autowired
    private SqlSession sqlSession_oracle;

    public List<MessageVO> searchMessage(Map<String,Object> messageInfo){
        MessengerMapper mapper= sqlSession_oracle.getMapper(MessengerMapper.class);

        return mapper.searchMessage(messageInfo);
    }

    public boolean updateReadState(int messageNum){
        MessengerMapper mapper= sqlSession_oracle.getMapper(MessengerMapper.class);

        return mapper.updateReadState(messageNum);
    }
    public boolean deleteMessage(Map<String,Object> messageInfo){
        MessengerMapper mapper= sqlSession_oracle.getMapper(MessengerMapper.class);

        return mapper.deleteMessage(messageInfo);
    }
    public int searchAllMessageCnt(Map<String,Object> messageinfo){
        MessengerMapper mapper= sqlSession_oracle.getMapper(MessengerMapper.class);
        return mapper.searchAllMessageCnt(messageinfo);
    }

    public MessageVO searchOneMessage(int messageId){
        MessengerMapper mapper= sqlSession_oracle.getMapper(MessengerMapper.class);
        return mapper.searchOneMessage(messageId);
    }
}
