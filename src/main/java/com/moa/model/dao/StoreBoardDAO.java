package com.moa.model.dao;

import com.moa.model.vo.SimpleStorageAddressVO;
import com.moa.model.vo.SimpleStorageBoardVO;
import com.moa.model.vo.StoreBoardFormVO;
import com.moa.model.vo.StoreBoardVO;

import java.util.List;
import java.util.Map;

public interface StoreBoardDAO {
    List<SimpleStorageAddressVO> selectStorageAddress(String hostId);
    List<String> selectTransaction();
    List<String> selectCategory();
    List<String> selectStoragePeriod();
    List<String> selectPrice();
    List<SimpleStorageBoardVO> searchMyStorage(Map<String, Object> storageInfo);
    int searchMyStorageCnt(int hostId);
    StoreBoardVO searchOne(int articleNum);
    int insert(StoreBoardFormVO storeBoardFormVO);
}
