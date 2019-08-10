package com.moa.mybatis;

import com.moa.model.vo.ReadStoreRequestVO;
import com.moa.model.vo.RequestProductVO;
import com.moa.model.vo.SimpleHostRequestVO;
import com.moa.model.vo.SimpleUserRequestVO;

import java.util.List;
import java.util.Map;

public interface StoreRequestMapper {
    List<SimpleHostRequestVO> searchListByHost(Map<String,Object> map);
    int searchAllListCnt(Map<String,Object> map);
    List<String> searchRequestPicture(int requestId);
    ReadStoreRequestVO searchRequestInfo(int requestId);
    List<SimpleUserRequestVO> searchRequestList(Map<String, Object> map);
    List<RequestProductVO> searchRequestProduct(int requestId);
    int searchRequestListCount(int userId);
}
