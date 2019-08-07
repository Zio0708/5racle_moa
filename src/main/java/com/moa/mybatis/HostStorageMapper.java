package com.moa.mybatis;

import com.moa.model.vo.*;

public interface HostStorageMapper {
    int insertOriginHome(OriginHomeStorageVO originHomeStorageVO);
    int insertOriginCompany(OriginCompanyStorageVO originCompanyStorageVO);
    int insertOriginOther(OriginOtherStorageVO originOtherStorageVO);
    int insertNewHome(NewHomeStorageVO newHomeStorageVO);
    int insertNewCompany(NewCompanyStorageVO newCompanyStorageVO);
    int insertNewOther(NewOtherStorageVO newOtherStorageVO);
}
