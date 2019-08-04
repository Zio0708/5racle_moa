package com.moa.model.dao;

import com.moa.mybatis.TransactionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TransactionDAOImpl {
    @Autowired
    private SqlSession sqlSession_oracle;

    public boolean update(Map<String,Object> map){
        TransactionMapper mapper = sqlSession_oracle.getMapper(TransactionMapper.class);
        return mapper.updateState(map);
    }
}
