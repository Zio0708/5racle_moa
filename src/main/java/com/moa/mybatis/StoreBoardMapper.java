package com.moa.mybatis;

import com.moa.model.vo.DetailOptionVO;
import com.moa.model.vo.EntrustResultSearchVO;
import com.moa.model.vo.EntrustSearchVO;
import com.moa.model.vo.SimpleStorageBoardVO;

import java.util.List;
import java.util.Map;

public interface StoreBoardMapper {
    Map<String,Object> selectOne(int articleNum);
    List<String> selectDetailPrice();
    List<EntrustSearchVO> searchEntrust(DetailOptionVO detail);
    List<SimpleStorageBoardVO> searchMyStorage(Map<String,Object> storageInfo);
    int searchMyStorageCnt(int hostId);
}
