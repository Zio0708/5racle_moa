package com.moa.model.dao;

import com.moa.model.vo.*;

import java.util.List;
import java.util.Map;

public interface StoreBoardDAO {
    List<EntrustSearchVO> searchEntrust(DetailOptionVO detail);

    StoreBoardVO searchOne(int articleNum);

    List<SimpleStorageBoardVO> searchMyStorage(Map<String, Object> storageInfo);

    int searchMyStorageCnt(int hostId);

    int insert(StoreBoardFormVO storeBoardFormVO);

    int delete(int articleNum);
}
