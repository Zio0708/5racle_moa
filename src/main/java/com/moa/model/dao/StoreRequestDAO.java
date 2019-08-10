package com.moa.model.dao;

import com.moa.model.vo.*;

import java.util.List;
import java.util.Map;

public interface StoreRequestDAO {
    int insert(StoreRequestVO storeRequestVO);
    ReadStoreRequestVO search(int requestId);
    List<SimpleUserRequestVO> searchList(int userId);
    List<SimpleHostRequestVO> searchListByHost(Map<String, Object> map);

    int searchAllListCnt(Map<String, Object> map);

}
