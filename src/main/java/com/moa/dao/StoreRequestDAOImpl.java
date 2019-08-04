package com.moa.dao;

import com.example.springmvc.mybatis.CheckLuggageMapper;
import com.example.springmvc.vo.StoreRequestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRequestDAOImpl implements StoreRequestDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_orcle;

    @Override
    public int insert(StoreRequestVO storeRequestVO) {
        CheckLuggageMapper mapper=sqlSession_orcle.getMapper(CheckLuggageMapper.class);
        mapper.insert(storeRequestVO);
        return storeRequestVO.getStoreRequestNum();
    }
}
