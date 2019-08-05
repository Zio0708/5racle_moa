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
    Map<String, Object> selectParameters(Map<String, Object> map);
    int insertIntoStoreBoard(Map<String, Object> map);
    int insertIntoPetType(Map<String, Object> map);
    int insertIntoSF_SB(Map<String, Object> map);
    int insertIntoSBAttachedPicture(Map<String, Object> map);
    int insertIntoDetailPriceFibo(Map<String, Object> map);
    int selectCategoryId(String category);
    int insertIntoForbiddenProduct(Map<String, Object> map);
}
