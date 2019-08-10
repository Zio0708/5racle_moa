package com.moa.model.dao;

import com.moa.model.vo.*;
import com.moa.mybatis.CheckLuggageMapper;
import com.moa.mybatis.HostStorageMapper;
import com.moa.mybatis.StoreRequestMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@NoArgsConstructor
public class StoreRequestDAOImpl implements StoreRequestDAO{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insert(StoreRequestVO storeRequestVO) {
        CheckLuggageMapper mapper=sqlSession.getMapper(CheckLuggageMapper.class);
        mapper.insert(storeRequestVO);
        return storeRequestVO.getStoreRequestNum();
    }
    @Override
    public ReadStoreRequestVO search(int requestId){
        StoreRequestMapper mapper = sqlSession.getMapper(StoreRequestMapper.class);
        ReadStoreRequestVO readStoreRequestVO;

        readStoreRequestVO = mapper.searchRequestInfo(requestId);
        System.out.println(readStoreRequestVO);
        List<RequestProductVO> productList = new ArrayList<>();

        productList = mapper.searchRequestProduct(requestId);
        System.out.println(productList);

        for(int i = 0 ; i < productList.size(); i++){
            readStoreRequestVO.getProductCategory().add(productList.get(i).getProductCategory());
            readStoreRequestVO.getProductCnt().add(productList.get(i).getProductCnt());
            readStoreRequestVO.getProductName().add(productList.get(i).getProductName());
        }

        List<String> pictureList = new ArrayList<>();
        pictureList = mapper.searchRequestPicture(requestId);

        for(int i = 0 ; i < pictureList.size(); i++){
            readStoreRequestVO.getPictureList().add(pictureList.get(i));
        }
        System.out.println("마지막 테스트 : " + readStoreRequestVO);

        return readStoreRequestVO;
    }
    @Override
    public List<SimpleUserRequestVO> searchList(int userId){
        StoreRequestMapper mapper = sqlSession.getMapper(StoreRequestMapper.class);
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
    public List<SimpleHostRequestVO> searchListByHost(Map<String,Object> map){
        StoreRequestMapper mapper = sqlSession.getMapper(StoreRequestMapper.class);

        return mapper.searchListByHost(map);
    }
    @Override
    public int searchAllListCnt(Map<String,Object> map){
        StoreRequestMapper mapper = sqlSession.getMapper(StoreRequestMapper.class);

        return mapper.searchAllListCnt(map);
    }
}
