package com.moa.model.dao;

import com.moa.model.vo.DetailOptionVO;
import com.moa.model.vo.EntrustResultSearchVO;
import com.moa.model.vo.EntrustSearchVO;
import com.moa.mybatis.StoreBoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreBoardDAOImpl implements StoreBoardDAO {
    @Autowired
    private SqlSession sqlSession_oracle;

    public List<EntrustSearchVO> searchEntrust(DetailOptionVO detail){
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        System.out.println("DAO 접근");
        List<EntrustSearchVO> entrustAry = mapper.searchEntrust(detail);
        System.out.println("DAO 완료"+entrustAry.get(1).getNickName());
        return entrustAry;
    }



}
