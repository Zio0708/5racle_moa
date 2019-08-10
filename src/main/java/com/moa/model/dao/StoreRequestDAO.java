package com.moa.model.dao;

import com.moa.model.vo.*;

import java.util.List;
import java.util.Map;

public interface StoreRequestDAO {
    public ReadStoreRequestVO search(int requestId);
    public List<SimpleUserRequestVO> searchList(int userId);
    int insert(StoreRequestVO storeRequestVO);

    List<SimpleHostRequestVO> searchListByHost(Map<String, Object> map);

    int searchAllListCnt(Map<String, Object> map);

}
