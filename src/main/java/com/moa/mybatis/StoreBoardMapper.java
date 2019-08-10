
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.moa.mybatis;

public interface StoreBoardMapper {
    java.util.List<com.moa.model.vo.SimpleStorageAddressVO> selectStorages(int i);

    java.util.List<java.lang.String> selectTransaction();

    java.util.List<java.lang.String> selectCategory();

    java.util.List<java.lang.String> selectStoragePeriod();

    java.util.List<java.lang.String> selectPrice();

    java.util.Map<java.lang.String,java.lang.Object> selectParameters(java.util.Map<java.lang.String,java.lang.Object> map);

    int insertIntoStoreBoard(java.util.Map<java.lang.String,java.lang.Object> map);

    int insertIntoPetType(java.util.Map<java.lang.String,java.lang.Object> map);

    int insertIntoSF_SB(java.util.Map<java.lang.String,java.lang.Object> map);

    int insertIntoSBAttachedPicture(java.util.Map<java.lang.String,java.lang.Object> map);

    int insertIntoDetailPriceFibo(java.util.Map<java.lang.String,java.lang.Object> map);

    int selectCategoryId(java.lang.String s);

    int insertIntoForbiddenProduct(java.util.Map<java.lang.String,java.lang.Object> map);

    java.util.Map<java.lang.String,java.lang.Object> selectOne(int i);

    java.util.List<java.lang.String> selectDetailPrice();

    java.util.List<com.moa.model.vo.EntrustSearchVO> searchEntrust(com.moa.model.vo.DetailOptionVO detailOptionVO);

    java.util.List<com.moa.model.vo.SimpleStorageBoardVO> searchMyStorage(java.util.Map<java.lang.String,java.lang.Object> map);

    int searchMyStorageCnt(int i);
}
