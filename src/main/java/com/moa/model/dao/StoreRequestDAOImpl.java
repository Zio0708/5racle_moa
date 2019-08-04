package com.moa.model.dao;

import com.moa.model.vo.RequestProductVO;
import com.moa.model.vo.SimpleUserRequestVO;
import com.moa.mybatis.StoreRequestMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
public class StoreRequestDAOImpl implements StoreRequestDAO {
    @Autowired
    private SqlSession sqlSession;

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
