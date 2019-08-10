package com.moa.mybatis;

import com.moa.model.vo.SimpleStorageAddressVO;

import java.util.List;
import java.util.Map;

public interface StoreBoardMapper {
    List<SimpleStorageAddressVO> selectStorages(int hostId);
    List<String> selectTransaction();
    List<String> selectCategory();
    List<String> selectStoragePeriod();
    List<String> selectPrice();

    Map<String, Object> selectParameters(Map<String, Object> map);
    int insertIntoStoreBoard(Map<String, Object> map);
    int insertIntoPetType(Map<String, Object> map);
    int insertIntoSF_SB(Map<String, Object> map);
    int insertIntoSBAttachedPicture(Map<String, Object> map);
    int insertIntoDetailPriceFibo(Map<String, Object> map);
    int selectCategoryId(String category);
    int insertIntoForbiddenProduct(Map<String, Object> map);
}
