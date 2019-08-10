package com.moa.model.dao;

import com.moa.model.vo.*;

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
    List<EntrustSearchVO> searchEntrust(DetailOptionVO detail);
    int insert(StoreBoardFormVO storeBoardFormVO);

    int delete(int articleNum);
}
