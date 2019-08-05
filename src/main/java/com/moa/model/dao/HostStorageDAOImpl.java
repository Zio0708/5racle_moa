package com.moa.model.dao;


import com.moa.model.vo.OriginCompanyStorageVO;
import com.moa.model.vo.*;
import com.moa.mybatis.HostReputationMapper;
import com.moa.mybatis.HostStorageMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class HostStorageDAOImpl implements HostStorageDAO{
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession;
    @Override
    public boolean insertOriginHome(OriginHomeStorageVO originHomeStorageVO){
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertOriginHome(originHomeStorageVO) != 0);

        return res;
    }
    @Override
    public boolean insertOriginCompany(OriginCompanyStorageVO originCompanyStorageVO){
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertOriginCompany(originCompanyStorageVO) != 0);

        return res;
    }
    @Override
    public boolean insertOriginOther(OriginOtherStorageVO originOtherStorageVO){
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertOriginOther(originOtherStorageVO) != 0);

        return res;
    }
    @Override
    public boolean insertNewHome(NewHomeStorageVO newHomeStorageVO) {
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertNewHome(newHomeStorageVO) != 0);

        return res;
    }
    @Override
    public boolean insertNewCompany(NewCompanyStorageVO newCompanyStorageVO) {
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertNewCompany(newCompanyStorageVO) != 0);

        return res;
    }
    @Override
    public boolean insertNewOther(NewOtherStorageVO newOtherStorageVO) {
        HostStorageMapper mapper = sqlSession.getMapper(HostStorageMapper.class);

        boolean res = (mapper.insertNewOther(newOtherStorageVO) != 0);

        return res;
    }

    @Override
    public HostReputationVO searchOne(int articleNum) {
        HostReputationMapper mapper=sqlSession.getMapper(HostReputationMapper.class);
        return mapper.selectOne(articleNum);
    }
}
