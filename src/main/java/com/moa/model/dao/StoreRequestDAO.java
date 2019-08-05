package com.moa.model.dao;

import com.moa.model.vo.SimpleHostRequestVO;
import com.moa.model.vo.SimpleUserRequestVO;
import com.moa.model.vo.StoreRequestVO;

import java.util.List;
import java.util.Map;

public interface StoreRequestDAO {
    List<SimpleUserRequestVO> searchList(int userId);

    int insert(StoreRequestVO storeRequestVO);

    List<SimpleHostRequestVO> searchListByHost(Map<String, Object> map);

    int searchAllListCnt(Map<String, Object> map);
}
