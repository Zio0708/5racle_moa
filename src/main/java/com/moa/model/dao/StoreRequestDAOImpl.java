package com.moa.model.dao;

import com.moa.model.vo.RequestProductVO;
import com.moa.model.vo.SimpleHostRequestVO;
import com.moa.model.vo.SimpleUserRequestVO;
import com.moa.model.vo.StoreRequestVO;
import com.moa.mybatis.CheckLuggageMapper;
import com.moa.mybatis.StoreRequestMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@NoArgsConstructor
public class StoreRequestDAOImpl implements StoreRequestDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_oracle;

    public List<SimpleUserRequestVO> searchList(int userId){
        StoreRequestMapper mapper = sqlSession_oracle.getMapper(StoreRequestMapper.class);
        List<SimpleUserRequestVO> simpleList = new ArrayList<SimpleUserRequestVO>();

        simpleList = mapper.searchRequestList(userId);
        System.out.println(simpleList);
        List<RequestProductVO> productList = new ArrayList<RequestProductVO>();

        for(int i = 0 ; i < simpleList.size(); i++) {
           productList = mapper.searchRequestProduct(simpleList.get(i).getRequestId());
            System.out.println(productList);

           for(int j = 0 ; j < productList.size(); j++){
               simpleList.get(i).getProductCategory().add(productList.get(j).getProductCategory());
               simpleList.get(i).getProductCnt().add(productList.get(j).getProductCnt());
               simpleList.get(i).getProductName().add(productList.get(j).getProductName());
           }
        }

        return simpleList;
    }

    @Override
    public int insert(StoreRequestVO storeRequestVO) {
        CheckLuggageMapper mapper=sqlSession_oracle.getMapper(CheckLuggageMapper.class);
        mapper.insert(storeRequestVO);
        return storeRequestVO.getStoreRequestNum();
    }
    @Override
    public List<SimpleHostRequestVO> searchListByHost(Map<String,Object> map){
        StoreRequestMapper mapper = sqlSession_oracle.getMapper(StoreRequestMapper.class);

        return mapper.searchListByHost(map);
    }
    @Override
    public int searchAllListCnt(Map<String,Object> map){
        StoreRequestMapper mapper = sqlSession_oracle.getMapper(StoreRequestMapper.class);

        return mapper.searchAllListCnt(map);
    }
}
