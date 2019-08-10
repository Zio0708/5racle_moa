package com.moa.model.dao;

import com.moa.model.vo.*;

import java.util.List;
import java.util.Map;

public interface StoreRequestDAO {
    int insert(StoreRequestVO storeRequestVO);
    public ReadStoreRequestVO search(int requestId);
    public List<SimpleUserRequestVO> searchList(int userId, int pageNum);
    public int countRequestList(int userId);
    int searchAllListCnt(Map<String, Object> map);
    public List<SimpleHostRequestVO> searchListByHost(Map<String,Object> map);
}
