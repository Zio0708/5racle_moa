package com.moa.dao;

import com.example.springmvc.mybatis.MemberMapper;
import com.example.springmvc.mybatis.StoreBoardMapper;
import com.example.springmvc.vo.StoreBoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreBoardDAOImpl implements StoreBoardDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_orcle;
    @Override
    public StoreBoardVO searchOne(int articleNum) {
        StoreBoardMapper mapper=sqlSession_orcle.getMapper(StoreBoardMapper.class);
        Map<String,Object> map=mapper.selectOne(articleNum);
        StoreBoardVO vo=new StoreBoardVO();

        vo.setArticleNum(articleNum);
        vo.setTitle((String)map.get("제목"));
        vo.setContent((String)map.get("내용"));
        vo.setWriteDate(((java.sql.Timestamp)map.get("작성일자")).toString());
        vo.setTransactionType((String)map.get("거래방식"));
        vo.setStorageType((String)map.get("보관지형태"));
        vo.setStoragePeriodType((String)map.get("보관기간"));
        vo.setBaseAddress((String)map.get("기본주소"));
        vo.setDetailAddress((String)map.get("상세주소"));
        vo.setForbiddenProduct((String)map.get("보관금지물품"));
        vo.setSecurityFacility((String)map.get("보안시설"));
        vo.setPet((String)map.get("펫"));
        vo.setPictureName(Arrays.asList(((String)map.get("사진명")).split(",")));
        List<String> detailPriceNameList = mapper.selectDetailPrice();
        List<String> detailPriceList=Arrays.asList(((String)map.get("상세가격")).split(","));
        Map<String,Integer> detailPriceMap=new HashMap<String,Integer>();
        for(int i=0;i<detailPriceNameList.size();i++)
            detailPriceMap.put(detailPriceNameList.get(i), Integer.parseInt(detailPriceList.get(i)));
        vo.setDetailPrice(detailPriceMap);
        return vo;
    }
}
