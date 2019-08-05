package com.moa.model.dao;

import com.example.springmvc.mybatis.HostReputationMapper;
import com.example.springmvc.vo.HostReputationVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HostReputationDAOImpl implements HostReputationDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_orcle;

    @Override
    public HostReputationVO searchOne(int articleNum) {
        HostReputationMapper mapper=sqlSession_orcle.getMapper(HostReputationMapper.class);
        return mapper.selectOne(articleNum);
    }
}
