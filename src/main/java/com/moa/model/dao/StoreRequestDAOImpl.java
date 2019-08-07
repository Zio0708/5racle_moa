package com.moa.model.dao;

import com.moa.model.vo.ReadStoreRequestVO;
import com.moa.model.vo.RequestProductVO;
import com.moa.model.vo.SimpleUserRequestVO;
import com.moa.mybatis.HostStorageMapper;
import com.moa.mybatis.StoreRequestMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class StoreRequestDAOImpl implements StoreRequestDAO{
    @Autowired
    private SqlSession sqlSession;

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
}
