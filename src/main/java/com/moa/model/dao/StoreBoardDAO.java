package com.moa.model.dao;

import com.moa.model.vo.SimpleStorageAddressVO;
import com.moa.model.vo.StoreBoardFormVO;

import java.util.List;

public interface StoreBoardDAO {
    List<SimpleStorageAddressVO> selectStorageAddress(String hostId);
    List<String> selectTransaction();
    List<String> selectCategory();
    List<String> selectStoragePeriod();
    List<String> selectPrice();

    int insert(StoreBoardFormVO storeBoardFormVO);

    int delete(int articleNum);
}
